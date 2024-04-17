package com.herbalmanagement.controller;

import com.herbalmanagement.pojo.HerbInfo;
import com.herbalmanagement.service.impl.HerbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HerbController {
    @Autowired
    private HerbServiceImpl herbService;
    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id,
                         @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                         RedirectAttributes ra){
        herbService.deleteById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/search";
    }
    //查询
    @GetMapping("/search")
    public String search(Model model,Integer id,
                         @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                         RedirectAttributes ra) {
        List<HerbInfo> all = new ArrayList<>();
        long l=0,i=0;
        if (id != null) {
            try {
                all.add(herbService.findById(id)); // 根据id查询
                pn = 1; l = 1; i = 1;
            } catch (RuntimeException e) {
                model.addAttribute("errorMessage", e.getMessage()); // 添加错误信息
                // 如果出错，可能需要保持页面其他数据不变，这里根据具体逻辑调整
            }
        } else {
            all = herbService.findAll(pn, 3); // 查询所有数据
            if (all.isEmpty()) { // 如果在删除记录后该页面没有任何数据，则再次重定向到查询页面
                ra.addAttribute("pn", --pn);
                ra.addAttribute("set", 1);
                return "redirect:/search";
            }
            l = herbService.countAll();
            i = (l % 3) > 0 ? (l / 3 + 1) : (l / 3);
        }
        model.addAttribute("herbs", all);
        model.addAttribute("pn", pn);//当前页码
        model.addAttribute("sum", l);//总记录数
        model.addAttribute("spn", i);//总页数
        return "forward:/herbList";
    }
    //添加
    @PostMapping("/addHerb")
    public String addHerb(HerbInfo herbInfo,
                          @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                          RedirectAttributes ra){
        herbService.add(herbInfo);
        ra.addAttribute("pn",pn);
        return "redirect:/search";
    }
    //修改
    @PostMapping("/updateHerb")
    public String updateHerb(HerbInfo herbInfo,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        herbService.update(herbInfo);
        ra.addAttribute("pn",pn);
        return "redirect:/search";
    }
    //根据id查找药材。如果没有输入任何信息，则id为默认值0
    @GetMapping("/getHerbById")
    public ResponseEntity<?> getHerbById(@RequestParam(value = "id",defaultValue = "0") int id) {
        try {
            HerbInfo herbInfo = herbService.findById(id);
            return new ResponseEntity<>(herbInfo, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
    //修改
    @GetMapping("/function")
    public String edit(@RequestParam(value = "set",defaultValue = "1")Byte set,
                       Model model,
                       @RequestParam(value = "id",defaultValue = "")Integer id){
        model.addAttribute("control",set);
        model.addAttribute("id",id);
        return "forward:/edit";
    }
    // 进货页面
    @GetMapping("/purchase")
    public String purchase(@RequestParam("id") Integer id, Model model) {
        HerbInfo herb = herbService.findById(id);
        model.addAttribute("herb", herb);
        return "table/purchasePage";
    }

    // 处理进货请求
    @PostMapping("/purchase")
    public String purchase(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
        herbService.purchase(id, quantity);
        return "redirect:/search";
    }

    // 处理购买请求
    @PostMapping("/buy")
    public String buy(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
        herbService.buy(id, quantity);
        return "redirect:/search";
    }
    // 检查药材名称是否存在
    @GetMapping("/checkHerbName")
    @ResponseBody
    public Map<String, Boolean> checkHerbName(@RequestParam String name) {
        boolean exists = herbService.checkHerbNameExists(name);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }
}

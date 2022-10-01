package com.woomq.controller;

import com.woomq.pojo.Product;
import com.woomq.service.GoodsService;
import com.woomq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

/**
 * @author Woo-mq
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    TypeService typeService;
    /**
     * @apiNote 获取全部商品列表
     * @return
     */
    @GetMapping("/getGoodsList/{typeId}")
    public String getGoodsList (@PathVariable("typeId")int typeId, Model model){
        //根据id获取类型名
        String typeName = typeService.getTypeNameById(typeId);
        Collection<Product> goodsListByTypeId = goodsService.getGoodsListByTypeId(typeId);
        model.addAttribute("type",typeName);
        model.addAttribute("products",goodsListByTypeId);
        return "goodsList";
    }

    /**
     * @apiNote 搜索框
     * @return
     */
    @GetMapping("/getSearchList")
    String getSearchList(Model model,String searchName){

        model.addAttribute("type",0);
        Collection<Product> searchList = goodsService.getSearchList(searchName);
        model.addAttribute("products",searchList);
        return "goodsList";
    }

}

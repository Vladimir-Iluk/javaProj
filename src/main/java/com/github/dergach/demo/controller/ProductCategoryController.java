package com.github.dergach.demo.controller;

import com.github.dergach.demo.data.entitys.ProductCategory;
import com.github.dergach.demo.data.entitys.ProductCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductCategoryController {
    private final ProductCategoryRepository categoryRepository;

    public ProductCategoryController(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "page/categories";
    }

    @GetMapping("/categories/add")
    public String showAddCategory(Model model) {
        return "page/category_add";
    }

    @PostMapping("/categories/add")
    public String addCategory(@RequestParam String name,
                              @RequestParam(required = false) String notes) {
        try {
            ProductCategory category = new ProductCategory();
            category.setName(name);
            category.setNotes(notes);
            categoryRepository.save(category);
            return "redirect:/categories";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/edit")
    public String showEditCategory(@RequestParam Long category_id, Model model) {
        var category = categoryRepository.findById(category_id).orElseThrow();
        model.addAttribute("category", category);
        return "page/category_edit";
    }

    @PostMapping("/categories/edit")
    public String editCategory(@RequestParam Long category_id,
                               @RequestParam String name,
                               @RequestParam(required = false) String notes) {
        try {
            ProductCategory category = categoryRepository.findById(category_id).orElseThrow();
            category.setName(name);
            category.setNotes(notes);
            categoryRepository.save(category);
            return "redirect:/categories";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/delete")
    public String deleteCategory(@RequestParam Long category_id) {
        try {
            categoryRepository.deleteById(category_id);
            return "redirect:/categories";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/categories";
        }
    }
}

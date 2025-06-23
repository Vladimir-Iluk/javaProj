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
    public String listCategories(@RequestParam(required = false) String sort,
                                 @RequestParam(required = false) String search,
                                 Model model) {
        Iterable<ProductCategory> categories;
        String sortDirection = (sort != null && sort.equals("asc")) ? "asc" : "desc";

        if (search != null && !search.isEmpty()) {
            categories = categoryRepository.searchAcrossAllFields(search);
        } else if ("asc".equals(sort)) {
            categories = categoryRepository.findAllByOrderByCategoryIdAsc();
        } else if ("desc".equals(sort)) {
            categories = categoryRepository.findAllByOrderByCategoryIdDesc();
        } else {
            categories = categoryRepository.findAll();
            sortDirection = "asc";
        }

        model.addAttribute("categories", categories);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("searchTerm", search);
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
    public String showEditCategory(@RequestParam Long categoryId, Model model) {
        var category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        return "page/category_edit";
    }

    @PostMapping("/categories/edit")
    public String editCategory(@RequestParam Long categoryId,
                               @RequestParam String name,
                               @RequestParam(required = false) String notes) {
        try {
            ProductCategory category = categoryRepository.findById(categoryId).orElseThrow();
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
    public String deleteCategory(@RequestParam Long categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return "redirect:/categories";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/categories";
        }
    }
}
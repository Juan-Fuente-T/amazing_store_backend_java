package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.api.IProductService;
import com.campusdual.amazing_store.model.Product;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class responsible for handling HTTP requests related to products.
 * It uses the {@link IProductService} to perform CRUD operations on products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Test endpoint to verify that the Products controller is working.
     * Responds with a simple message.
     *
     * @return A string indicating that the controller works.
     */
    @GetMapping
    public String testController(){
        return "Products controller works!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerGet2() {
        return "El metodo del controller Get2 funciona ok!";
    }
    /**
     * Test endpoint to verify that the Products controller supports POST requests.
     * Accepts a name parameter in the request body and responds with a confirmation message.
     *
     * @param name The name received in the request body.
     * @return A string confirming that the POST request was successful, including the received name.
     */
    @PostMapping
    public String testControllerPost(@RequestBody String name){
        return "Products controller POST works! " + name + "!";
    }

    /**
     * Endpoint to retrieve a single product based on the provided {@link ProductDTO}.
     *
     * @param productDTO The {@link ProductDTO} object containing the criteria for the query.
     * @return The {@link ProductDTO} object representing the queried product.
     */
    @PostMapping(value= "/get")
    public ProductDTO queryProduct(@RequestBody ProductDTO productDTO){
        return this.productService.queryProduct(productDTO);
    }
    /**
     * Endpoint to retrieve a list of all products.
     *
     * @return A list of {@link ProductDTO} objects representing all products.
     */
    @GetMapping(value = "/getAll")
    public List<ProductDTO> queryAllProducts(){
        return productService.queryAllProducts();
        }
//    @PostMapping(value = "/add")
//    public int addProduct (@RequestBody ProductDTO productDTO) {
//        return productService.insertProduct(productDTO);
//    }
    /**
     * Endpoint to add a new product to the system.
     * Accepts a {@link ProductDTO} in the request body and returns the ID of the newly inserted product.
     *
     * @param productDTO The {@link ProductDTO} object containing the details of the new product.
     * @return A map containing the ID of the newly inserted product.
     */
    @PostMapping("/add")
    public ResponseEntity<Map<String, Integer>> addProduct(@RequestBody ProductDTO productDTO) {
        int id = productService.insertProduct(productDTO);
        Map<String, Integer> response = new HashMap<>();
        response.put("id", id);
        return ResponseEntity.ok(response);
    }
    /**
     * Endpoint to update an existing product in the system.
     * Accepts a {@link ProductDTO} in the request body and returns the number of rows affected by the update.
     *
     * @param productDTO The {@link ProductDTO} object containing the updated details of the product.
     * @return The number of rows affected by the update operation.
     */
    @PutMapping(value = "/update")
    public int updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }
    /**
     * Endpoint to delete a product from the system.
     * Accepts a {@link ProductDTO} in the request body and returns the number of rows deleted by the operation.
     *
     * @param productDTO The {@link ProductDTO} object identifying the product to be deleted.
     * @return The number of rows deleted by the operation.
     */
    @DeleteMapping(value = "/delete")
    public int deleteProduct(@RequestBody ProductDTO productDTO){
        return productService.deleteProduct(productDTO);
    }

//    @GetMapping(value = "/filteredData/{type}")
//    public List<Object[]> getFilteredProductsAndContactsByType(@PathVariable String type) {
//        return productService.getFilteredProductsAndContactsByType(type);
//    }

//    @GetMapping(value = "/filteredData")
//    public List<Object[]> getFilteredProductsAndContactsByType() {
//        return productService.getFilteredProductsAndContactsByType();
//    }
}

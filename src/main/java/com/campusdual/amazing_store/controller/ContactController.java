package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.api.IContactService;
import com.campusdual.amazing_store.model.dto.ContactDTO;
import com.campusdual.amazing_store.api.IProductService;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import com.campusdual.amazing_store.model.dto.CombinedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private IContactService contactService;

    @Autowired
    private IProductService productService;

    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testControllerPost(@RequestBody String name){
        return "Contacts controller POST works! " + name + "!";
    }
    @GetMapping(value = "/testMethod")
    public String testControllerGet2() {
        return "El metodo del controller de Contacts, Get2 funciona ok!";
    }

    @PostMapping(value= "/get")
    public ContactDTO queryContact(@RequestBody ContactDTO contactDTO){
        return this.contactService.queryContact(contactDTO);
    }
    @GetMapping(value = "/getAll")
    public List<ContactDTO> queryAllContacts() {
        return contactService.queryAllContacts();
    }
    @PostMapping(value = "/add")
    public int addContact (@RequestBody ContactDTO contactDTO){
        return contactService.insertContact(contactDTO);
    }
    @PutMapping(value = "/update")
    public int updateContact (@RequestBody ContactDTO contactDTO){
        return contactService.updateContact(contactDTO);
    }
    @DeleteMapping(value = "/delete")
    public int deleteContact (@RequestBody ContactDTO contactDTO){
        return contactService.deleteContact(contactDTO);
    }



    /*@GetMapping(value = "/combinedData")
    public List<CombinedDTO> combinedData() {
        // Utiliza el resultado de queryAllContacts() para obtener todos los contactos
        List<ContactDTO> contacts = contactService.queryAllContacts();

        // Obtener todos los productos
        List<ProductDTO> products = productService.queryAllProducts(); // Asumiendo que tienes un método similar en ProductService

        // Crear una lista de CombinedDTO que contiene información de ambos tipos de datos
        List<CombinedDTO> combinedList = new ArrayList<>();
        for (ContactDTO contact : contacts) {
            CombinedDTO combined = new CombinedDTO();
            combined.setContactInfo(contact); // Asume que tienes setters para esto
            combined.setProductInfo(products.stream()
                    .filter(product -> product.getProduct_type().equals(contact.getProduct_type()))
                    .findFirst()
                    .orElse(null)); // Encuentra el producto con el mismo tipo de producto
            combinedList.add(combined);
        }

        return combinedList;
    }*/

}

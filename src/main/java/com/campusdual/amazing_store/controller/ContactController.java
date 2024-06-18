package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.api.IContactService;
import com.campusdual.amazing_store.model.dto.ContactDTO;
import com.campusdual.amazing_store.api.IProductService;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import com.campusdual.amazing_store.model.dto.CombinedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsible for handling HTTP requests related to contacts.
 * It exposes endpoints to perform CRUD operations on contacts and to test
 * the functionality of the controller itself.
 */
@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private IContactService contactService;

    /**
     * Test endpoint to verify that the controller is working correctly.
     * Responds with a simple message.
     *
     * @return A string indicating that the controller works.
     */
    @GetMapping
    public String testController() {
        return "Contacts controller works!";
    }

    /**
     * Test endpoint to verify that the controller handles POST requests correctly.
     * Responds with a message including the received name parameter.
     *
     * @param name The name parameter received in the request body.
     * @return A string indicating that the controller works and including the received name.
     */
    @PostMapping
    public String testControllerPost(@RequestBody String name) {
        return "Contacts controller POST works " + name + "!";
    }

    /**
     * Another test endpoint demonstrating GET request handling.
     * Responds with a custom message.
     *
     * @return A string indicating that the GET2 method works.
     */
    @GetMapping(value = "/testMethod")
    public String testControllerGet2() {
        return "El metodo del controller de Contacts, Get2 funciona ok!";
    }

    /**
     * Endpoint to query a single contact based on the provided {@link ContactDTO}.
     * Delegates the query logic to {@link IContactService#queryContact(ContactDTO)}.
     *
     * @param contactDTO The {@link ContactDTO} object containing the criteria for the query.
     * @return The {@code ContactDTO} object representing the queried contact.
     */
    @PostMapping(value = "/get")
    public ContactDTO queryContact(@RequestBody ContactDTO contactDTO) {
        return this.contactService.queryContact(contactDTO);
    }

    /**
     * Endpoint to retrieve a list of all {@link ContactDTO} objects stored in the system.
     * Delegates the retrieval logic to {@link IContactService#queryAllContacts()}.
     *
     * @return A list of {@code ContactDTO} objects representing all contacts.
     */
    @GetMapping(value = "/getAll")
    public List<ContactDTO> queryAllContacts() {
        return contactService.queryAllContacts();
    }

    /**
     * Endpoint to insert a new contact into the system using the provided {@link ContactDTO}.
     * Delegates the insertion logic to {@link IContactService#insertContact(ContactDTO)}.
     *
     * @param contactDTO The {@link ContactDTO} object containing the details of the new contact.
     * @return The ID of the newly inserted contact.
     */
    @PostMapping(value = "/add")
    public int addContact(@RequestBody ContactDTO contactDTO) {
        return contactService.insertContact(contactDTO);
    }

    /**
     * Endpoint to update an existing contact in the system using the provided {@link ContactDTO}.
     * Delegates the update logic to {@link IContactService#updateContact(ContactDTO)}.
     *
     * @param contactDTO The {@link ContactDTO} object containing the updated details of the contact.
     * @return The number of rows affected by the update operation.
     */
    @PutMapping(value = "/update")
    public int updateContact(@RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(contactDTO);
    }
    /**
     * Endpoint to delete a contact from the system using the provided {@link ContactDTO}.
     * Delegates the deletion logic to {@link IContactService#deleteContact(ContactDTO)}.
     *
     * @param contactDTO The {@link ContactDTO} object identifying the contact to be deleted.
     * @return The number of rows deleted by the operation.
     */
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

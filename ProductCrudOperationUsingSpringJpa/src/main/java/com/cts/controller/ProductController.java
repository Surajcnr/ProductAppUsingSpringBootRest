package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFoundException;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController // controller + responseBody
@RequestMapping("/products") // http://localhost:2222/products
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // @RequestMapping(value = "/getMsg",method=RequestMethod.GET)
							// //http://localhost:2222/products/getMsg
	public String sayHello() {
		return "am trying to listen but need break";
	}

	@PostMapping("/saveproduct") // http://localhost:2222/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/update") // http://localhost:2222/products/update
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/getproduct/{pid}") // http://localhost:2222/products/getProduct
	public Product getProductById(@PathVariable("pid") int productId) throws ProductNotFoundException {
		return service.getProduct(productId);
	}

	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:2222/products/getProduct
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}

	@GetMapping("/getallproduct") // http://localhost:2222/products/getallproduct
	public List<Product> getALlProduct() {
		return service.getAllProducts();
	}

	@GetMapping("/getallproductbtw/{ini}/{fin}") // http://localhost:2222/products/getallproductbtw
	public List<Product> getALlProductBetween(@PathVariable("ini") int intitalPrice,
			@PathVariable("fin") int finalPrice) {
		return service.getAllProductsBetween(intitalPrice, finalPrice);
	}

	@GetMapping("/getallproductbycat/{cat}") // http://localhost:2222/products/getallproductbycat
	public List<Product> getALlProductByCategory(@PathVariable("cat") String category) {
		return service.getAllProductsByCategory(category);
	}

	@GetMapping("/getallproductabove/{price}") // http://localhost:2222/products/getallproductbycat
	public List<Product> getALlProductByCategory(@PathVariable("price") int price) {
		return service.getAllProductsAboveGivenPrice(price);
	}
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
 
}
package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 Double calculateOrderValue(List items)
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(item ->productRepository.findById(item.getProductId())
				.map(produto -> produto.getIsSale() ? produto.getValue() * 0.80 : produto.getValue())
				.orElse(0.00) * item.getQuantity()).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	*/
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(produto -> productRepository.findById(produto).orElse(null))
				.filter(Objects::nonNull).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(itens -> calculateOrderValue(itens)).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().map(produto -> productRepository.findById(produto).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}
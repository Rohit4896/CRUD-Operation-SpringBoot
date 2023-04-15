package ProductManagementRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductManagementModel.Product;

public interface ProductRepository extends JpaRepository<Product, Integer > {

}

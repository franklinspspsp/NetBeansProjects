package product;

import java.text.MessageFormat;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;



public class Product {
    
        private final IntegerProperty price = new SimpleIntegerProperty();
        private final IntegerProperty cost = new SimpleIntegerProperty();
        private final ReadOnlyIntegerWrapper profit = new ReadOnlyIntegerWrapper();
        public Product() {
        // the property itself can be written to
    profit.bind(price.subtract(cost));
    }
        public final int getCost() {
        return this.cost.get();
          }
        public final void setCost(int value) {
        this.cost.set(value);
    }
        public final IntegerProperty costProperty() {
        return this.cost;
        }
        public final int getPrice() {
        return this.price.get();
        }
        public final void setPrice(int value) {
        this.price.set(value);
        }
        public final IntegerProperty priceProperty() {
        return this.price;
        }
        public final int getProfit() {
        return this.profit.get();
        }
        public final ReadOnlyIntegerProperty profitProperty() {
        // return a readonly view of the property
        return this.profit.getReadOnlyProperty();
        }
        public static void main(String[] args) {
        Product product = new Product();
        product.profitProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue,
        Number newValue) {
         System.out.println(MessageFormat.format("The profit changed from {0}$ to{1}$", oldValue, newValue));
        } 
        });
        product.setCost(40);
        product.setPrice(50);
        product.setCost(20);
        product.setPrice(30);
        }
}
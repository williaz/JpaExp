package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by williaz on 10/10/16.
 */
@Entity(name = "PRODUCT")
public class Product implements Serializable{
    @Id
    @Column(name = "PROD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prodId;

    @Column(name = "PROD_NAME", nullable = false,length = 50)
    private String prodName;

    @Column(name = "PROD_DESC", length = 200)
    private String prodDescription;

    @Column(name = "REGULAR_PRICE", precision = 2)
    private String price;

    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orders = new ArrayList<>();
    //private List<OrderDetail> orders = new ArrayList<>();

    public Product(String prodName, String prodDescription, String price, Date updatedTime) {
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.price = price;
        this.updatedTime = updatedTime;
    }

    public Product() {
    }

    public long getProdId() {
        return prodId;
    }

    public List<OrderDetail> getOrders() {
        return orders;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return prodId == product.prodId;

    }

    @Override
    public int hashCode() {
        return (int) (prodId ^ (prodId >>> 32));
    }
}

package com.mama.pride.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.mama.pride.enums.PaymentMethod;
import com.mama.pride.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "user_id")
    private int userId;

    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_quantity")
    private int productQuantity;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "DEPTARTMENT_NAME", referencedColumnName = "Name"),
            @JoinColumn(name = "DEPTARTMENT_ID", referencedColumnName = "Id"),
    })

    @OneToOne()
    @JoinColumn(name = "staff_id")
    private UserProfile staffId;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    public Order(int order_id, Date deliveryDate, Date orderDate,
            // PaymentMethod paymentMethod,
            int productQuantity, UserProfile staffId, int userId, Status status) {
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.orderId = order_id;
        // this.paymentMethod = paymentMethod;
        this.productQuantity = productQuantity;
        this.staffId = staffId;
        this.userId = userId;
        this.status = status;

    }

    public Order(int order_id, Date deliveryDate, Date orderDate, Product product,
            // PaymentMethod paymentMethod,
            int productQuantity, int userId, Status status) {
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.orderId = order_id;
        // this.paymentMethod = paymentMethod;
        this.product = product;
        this.productQuantity = productQuantity;
        this.userId = userId;
        this.status = status;

    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + " product=" + product + "userId=" + userId + " productQuantity="
                + productQuantity + " orderDate=" + orderDate + " deliveryDate=" + deliveryDate + " status=" + status
                + " staffId=" + staffId + "]";
    }

    /**
     * @return the paymentMethod
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the staffId
     */
    public UserProfile getStaffId() {
        return staffId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setStaffId(UserProfile staffId) {
        this.staffId = staffId;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the productQuantity
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param productQuantity the productQuantity to set
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}

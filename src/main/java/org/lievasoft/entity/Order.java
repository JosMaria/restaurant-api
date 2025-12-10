//package org.lievasoft.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "ticket_id", nullable = false)
//    private Long ticketId;
//
//    @ManyToOne
//    @JoinColumn(nullable = false, name = "food_id")
//    private Food food;
//
//    private int quantity;
//
//    @Column(name = "to_go")
//    private boolean toGo;
//
//    public Order() {
//    }
//
//    public Order(Food food, int quantity, boolean toGo) {
//        this.food = food;
//        this.quantity = quantity;
//        this.toGo = toGo;
//    }
//
////    public void setTicket(Ticket ticket) {
////        this.ticket = ticket;
////    }
//}

package org.example.shunin.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Item name should not be empty")
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(columnDefinition = "person_id", referencedColumnName = "id")
    private Person person;

    public Item() {
    }

    public Item(int id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

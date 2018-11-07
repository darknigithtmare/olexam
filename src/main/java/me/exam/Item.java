package me.exam;

import javax.persistence.*;

/**
 * Created by DarKnightMare on 11/6/2018.
 */

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;

    @Column(name = "Amount", nullable = false)
    private int amount;

    @Column(name = "Code", length = 64, nullable = false)
    private String code;

    public Item() {  }

    public Item(int id, String name, int amount, String code) {
        this.setId(id);
        this.setName(name);
        this.setAmount(amount);
        this.setCode(code);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

package net.proselyte.springmvc.model;





import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 26.06.16.
 */
@Entity
public class Waiter extends  Employee {

    public Waiter()
    {
        this.setPosition(Position.WAITER);
    }


     @OneToMany(mappedBy = "waiter", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
           private Set<Orders> orders;

      public Set<Orders> getOrders() {return orders; }

     public void setOrders(Set<Orders> orders) {this.orders= orders;  }

           @Override
            public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Waiter (\n");
            sb.append("id = (\n").append(getId()).append("\n");
            sb.append("name = (\n").append(getName()).append("\n");
            sb.append("surname = (\n").append(getSurname()).append("\n");
            sb.append("orders = (\n");
            sb.append(" )\n");
            sb.append(")\n");
            return sb.toString();
            }
}

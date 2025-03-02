package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "personas")
public class Coche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String marca;
    @OneToMany(mappedBy = "coches")
    private Persona persona;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "talleres",joinColumns = @JoinColumn(name = "id_coche"),inverseJoinColumns = @JoinColumn(name = "id_taller"))
    private List<Taller> talleres;
}

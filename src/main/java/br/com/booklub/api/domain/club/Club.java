package br.com.booklub.api.domain.club;

import br.com.booklub.api.domain.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="club")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
@Setter
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

}

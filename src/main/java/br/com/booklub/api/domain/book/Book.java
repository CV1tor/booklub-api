package br.com.booklub.api.domain.book;

import br.com.booklub.api.domain.author.Author;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="book")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable=false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @NonNull
    @Column(nullable=false)
    private BookGenre genre;

    @NonNull
    @Column(nullable=false)
    private Integer pages;

    @NonNull
    @Column(nullable=false)
    private Integer price; // store in cents

    @NonNull
    @Column(nullable=false)
    private Integer quantity;


}

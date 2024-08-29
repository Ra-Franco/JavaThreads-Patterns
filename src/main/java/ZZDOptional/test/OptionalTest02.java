package ZZDOptional.test;

import ZZDOptional.domain.Manga;
import ZZDOptional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {

        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
        mangaByTitle.ifPresent(m -> m.setTitle("Boku no Hero 2"));
        System.out.println(mangaByTitle.get());

        Manga mangaById = MangaRepository.findById(2)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        String title = "One Piece";
        Manga newManga = MangaRepository.findByTitle(title)
                .orElse(new Manga(3, title, 1004));
        System.out.println(newManga);

    }
}

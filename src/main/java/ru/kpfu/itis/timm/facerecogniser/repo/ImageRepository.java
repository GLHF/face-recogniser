package ru.kpfu.itis.timm.facerecogniser.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.timm.facerecogniser.model.Image;

public interface ImageRepository extends JpaRepository<Image, String> {
}

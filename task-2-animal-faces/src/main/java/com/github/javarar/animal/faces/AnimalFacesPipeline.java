package com.github.javarar.animal.faces;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AnimalFacesPipeline {
    // загрузка файлов из дерриктории (можно параллельно)
    // изменение картинки (можно параллельно, рабиение зависит от метода трансформации)
    // запись измененных картинок на диск

    private static final String path = "/resources/%s";

    public void transform(String name) {
        BufferedImage readImage = readImage(name);
        BufferedImage changeImage = changeColorToBlackAndWhiteInImage(readImage);
        saveImage(name, changeImage);
    }

    @SneakyThrows
    public BufferedImage readImage(String name) {
        return ImageIO.read(new File(name != null ? name : "test.jpg"));
    }

    @SneakyThrows
    public void saveImage(String name, BufferedImage image) {
        File outputfile = new File(name != null ? "new-%s".formatted(name) : "new-test.jpg");
        ImageIO.write(image, "png", outputfile);
    }

    public BufferedImage changeColorToBlackAndWhiteInImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int finalX = x;
                int finalY = y;

                futures.add(
                        CompletableFuture.runAsync(() -> {
                            int[] pixels = raster.getPixel(finalX, finalY, (int[]) null);
                            pixels[0] = 0;
                            pixels[1] = 0;
                            pixels[2] = 255;
                            raster.setPixel(finalX, finalY, pixels);
                        })
                );
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return image;
    }
}

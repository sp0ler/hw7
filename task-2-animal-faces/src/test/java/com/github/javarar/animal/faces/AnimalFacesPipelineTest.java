package com.github.javarar.animal.faces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AnimalFacesPipelineTest {

    @Test
    void transformTest() {
        AnimalFacesPipeline animalFacesPipeline = new AnimalFacesPipeline();
        assertDoesNotThrow(() -> animalFacesPipeline.transform(null));
    }
}
package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.example.DesignerPDFViewer.designerPdfViewer;
import static com.example.Helpers.asIntList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignerPDFViewerTest {
    @ParameterizedTest()
    @CsvFileSource(resources = "/designer-pdf-viewer.csv", numLinesToSkip = 1, maxCharsPerColumn = 10000)
    void tests(String heights, String word, Integer highlight) {
        assertEquals(highlight, designerPdfViewer(asIntList(heights), word));
    }
}

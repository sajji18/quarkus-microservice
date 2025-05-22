package org.agoncal.quarkus.microservices.number;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Several ISBN formats")
public class IsbnNumbers {
    @JsonbProperty("isbn_10")
    @Schema(required = true)
    public String isbn10;

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    public String isbn13;

    @JsonbTransient
    public Instant generationData;
}

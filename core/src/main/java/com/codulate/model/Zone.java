package com.codulate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="zones")
public class Zone {
    @Id
    private String id;
    private String name;
    private Coordinates coordinates;

    public Zone() {
    }

    public Zone(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public Zone(String id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

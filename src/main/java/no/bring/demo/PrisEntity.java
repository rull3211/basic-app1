package no.bring.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrisEntity { // dette blir databaseskjemaet med objekter som rader og instansvariabler som kolonner

    public PrisEntity(){}
    public PrisEntity(int basePrice, int packetPrice, int weightPrice) {
        this.basePrice = basePrice;
        this.packetPrice = packetPrice;
        this.weightPrice = weightPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //id i dette tilfelle kunne vært postnummer
    private int basePrice;
    private int packetPrice;
    private int weightPrice;

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPacketPrice() {
        return packetPrice;
    }

    public void setPacketPrice(int packetPrice) {
        this.packetPrice = packetPrice;
    }

    public int getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(int weightPrice) {
        this.weightPrice = weightPrice;
    }

    @Override
    public String toString() {
        return "PrisEntity{" +
                "id=" + id +
                ", basePrice=" + basePrice +
                ", packetPrice=" + packetPrice +
                ", weightPrice=" + weightPrice +
                '}';
    }
}

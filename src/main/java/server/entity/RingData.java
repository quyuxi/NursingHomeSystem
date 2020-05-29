package server.entity;


import lombok.Data;

@Data
public class RingData {

    private Physiological physiological;
    private Posture posture;
    private Position position;
    private RingInfo ringInfo;

    public RingData(Physiological physiological, Posture posture, Position position, RingInfo ringInfo) {

        this.physiological = physiological;
        this.posture = posture;
        this.position = position;
        this.ringInfo = ringInfo;
    }

    public RingData() {
    }
}

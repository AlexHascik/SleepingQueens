import java.util.Optional;

public class Position {

    private Optional<HandPosition> handPosition;
    private Optional<SleepingQueenPosition> sleepingQueenPosition;
    private Optional<AwokenQueenPosition> awokenQueenPosition;

//    public Position(HandPosition handPosition){
//        this.handPosition = new HandPosition(handPosition.getCardIndex(), handPosition.getPlayerIndex());
//    }
//    public Position(SleepingQueenPosition sleepingQueenPosition){
//        this.sleepingQueenPosition = new SleepingQueenPosition(sleepingQueenPosition.getCardIndex());
//    }
//    public Position(AwokenQueenPosition awokenQueenPosition){
//        this.awokenQueenPosition = new AwokenQueenPosition(awokenQueenPosition.getCardIndex(), awokenQueenPosition.getPlayerIndex());
//    }

    public Position(HandPosition handPosition){
        this.handPosition = Optional.of(handPosition);
    }
    public Position(SleepingQueenPosition sleepingQueenPosition){
        this.sleepingQueenPosition = Optional.of(sleepingQueenPosition);
    }
    public Position(AwokenQueenPosition awokenQueenPosition){
        this.awokenQueenPosition = Optional.of(awokenQueenPosition);
    }

    public Optional<HandPosition> getHandPosition() {
        return handPosition;
    }

    public Optional<AwokenQueenPosition> getAwokenQueenPosition() {
        return awokenQueenPosition;
    }

    public Optional<SleepingQueenPosition> getSleepingQueenPosition() {
        return sleepingQueenPosition;
    }
}

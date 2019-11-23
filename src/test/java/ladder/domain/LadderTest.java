package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    @DisplayName("각 Line의 size가 다를 때 예외처리")
    void createException() {
        Line line1 = Line.of(List.of(Direction.RIGHT, Direction.LEFT));
        Line line2 = Line.of(List.of(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT));
        List<Line> lines = List.of(line1, line2);

        assertThrows(IllegalArgumentException.class, () -> Ladder.of(lines));
    }

    @Test
    @DisplayName("null 검사")
    void createException01() {
        assertThrows(NullPointerException.class, () -> Ladder.of(null));
    }

    @Test
    @DisplayName("lines 최소 사이즈 검사")
    void createException02() {
        assertThrows(IllegalArgumentException.class, () -> Ladder.of(Collections.emptyList()));
    }

    @Test
    @DisplayName("마지막까지 이동 확인")
    void moveTest() {
        // given
        Line line1 = Line.of(List.of(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT));
        Line line2 = Line.of(List.of(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT));
        List<Line> lines = List.of(line1, line2);
        Ladder ladder = Ladder.of(lines);

        Position startPosition = Position.from(0);
        Position expected = Position.from(2);

        // when
        Position actual = ladder.moveUntilEnd(startPosition);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
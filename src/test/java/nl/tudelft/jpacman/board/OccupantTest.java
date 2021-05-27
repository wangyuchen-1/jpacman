package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        /* Remove the following placeholder(删除下列占位符):
        *测试断言一个单元开始时没有正方形，也就是说，一个单元开始时“没有正方形”
        */
        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation(测试单位在占领后确实有目标方格作为其基地。).
     */
    @Test
    void testOccupy() {
        /* Remove the following placeholder:
        *验证单元在被占用后确实有目标正方形作为它的基数。换句话说，如果一个单元被一个(ny)基本方块占据，那么一个应该包含另一个

         */
        Square square = new BasicSquare();
        unit.occupy(square);
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation(两次占领后).
     */
    @Test
    void testReoccupy() {
        /* Remove the following placeholder:
        *验证单元在两次占用之后确实有目标正方形作为它的基数。如果这个单元被另一个方块占用了，会发生什么?

         */
        Square square = new BasicSquare();
        unit.occupy(square);
        unit.occupy(square);
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit).containsOnlyOnce(unit);
    }
}

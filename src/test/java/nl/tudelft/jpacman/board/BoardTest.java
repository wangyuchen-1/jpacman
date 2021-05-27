package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BoardTest {
    private static final int MAX_WIDTH = 4;
    private static final int MAX_HEIGHT = 5;
    private static Square[][] grid = {
        {mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)},
        {mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)},
        {mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)}
    };

    private final Board board = new Board(grid);

    @Test
    @DisplayName("测试边界宽度是否小于最大宽度")
    void verifyWidth(){
        assertThat(board.getWidth()).isLessThanOrEqualTo(MAX_WIDTH);
    }

    @Test
    @DisplayName("测试边界高度是否小于最大高度")
    void verifyHeight(){
        assertThat(board.getHeight()).isLessThanOrEqualTo(MAX_HEIGHT);
    }

    @DisplayName("边界值方法测试游戏有边界")
    @ParameterizedTest
    @CsvSource({
        "0,2,true",
        "1,2,true",
        "4,2,false"
    })

    void testWithinBorder(int x,int y,boolean result){
        assertThat(board.withinBorders(x,y)).isEqualTo(result);
    }

}

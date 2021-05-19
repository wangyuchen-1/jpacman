package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

//测试魔鬼Clyde的移动方法nextAiMove
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClydeTest {
    public MapParser setup(){
        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            mock(PointCalculator.class)
        );
        BoardFactory boardFactory = new BoardFactory(sprites);
        GhostFactory ghostFactory = new GhostFactory(sprites);
        return new GhostMapParser(levelFactory,boardFactory,ghostFactory);
    }

    @Test
    @DisplayName("Clyde离Player距离小于8个方块")
    @Order(1)
    void departLessThanEight(){
        //Arrange
        MapParser mapParser = setup();
        List<String> text = Lists.newArrayList(
            "##############",
            "#.#....C.....P",
            "##############");
        Level level = mapParser.parseMap(text);

        //在棋盘中找到魔鬼对象
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        assertThat(clyde).isNotNull();
        assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));

        //创建Player
        Player player = new PlayerFactory(new PacManSprites()).createPacMan();
        player.setDirection(Direction.valueOf("WEST"));
        //注册player到地图中去
        level.registerPlayer(player);
        Player p = Navigation.findUnitInBoard(Player.class,level.getBoard());
        assertThat(p).isNotNull();
        assertThat(p.getDirection()).isEqualTo(Direction.valueOf("WEST"));

        //act:
        Optional<Direction> opt = clyde.nextAiMove();

        //assert:
        assertThat(opt.get()).isEqualTo(Direction.valueOf("WEST"));
    }

    @Test
    @DisplayName("Clyde离Player距离大于8个方块")
    @Order(2)
    void departMoreThanEight(){
        //Arrange
        MapParser mapParser = setup();
        List<String> text = Lists.newArrayList(
            "##############",
            "#.C..........P",
            "##############");
        Level level = mapParser.parseMap(text);

        //在棋盘中找到魔鬼对象
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        assertThat(clyde).isNotNull();
        assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));

        //创建Player
        Player player = new PlayerFactory(new PacManSprites()).createPacMan();
        player.setDirection(Direction.valueOf("WEST"));
        //注册player到地图中去
        level.registerPlayer(player);
        Player p = Navigation.findUnitInBoard(Player.class,level.getBoard());
        assertThat(p).isNotNull();
        assertThat(p.getDirection()).isEqualTo(Direction.valueOf("WEST"));

        //act:
        Optional<Direction> opt = clyde.nextAiMove();

        //assert:
        assertThat(opt.get()).isEqualTo(Direction.valueOf("EAST"));
    }

    @Test
    @DisplayName("棋盘中没有Player对象")
    @Order(3)
    void departWithoutPlayer(){
        //Arrange
        MapParser mapParser = setup();
        List<String> text = Lists.newArrayList(
            "##############",
            "#.C...........",
            "##############");
        Level level = mapParser.parseMap(text);

        //在棋盘中找到魔鬼对象
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        assertThat(clyde).isNotNull();
        assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));

        //判断棋盘中是否有游戏对象
        assertThat(level.isAnyPlayerAlive()).isFalse();

        //act:
        Optional<Direction> opt = clyde.nextAiMove();

        //assert:
        assertThat(opt.isPresent()).isFalse();
    }

    @Test
    @DisplayName("Clyde与Player没有路径可到达")
    @Order(4)
    void withoutPathBetweenClydeAndPlayer(){
        //Arrange
        MapParser mapParser = setup();
        List<String> text = Lists.newArrayList(
            "#############P",
            "#.C...........",
            "##############");
        Level level = mapParser.parseMap(text);

        //在棋盘中找到魔鬼对象
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        assertThat(clyde).isNotNull();
        assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));

        assertThat(level.isAnyPlayerAlive()).isFalse();

        //act:
        Optional<Direction> opt = clyde.nextAiMove();

        //assert:
        assertThat(opt.isPresent()).isFalse();
    }
}

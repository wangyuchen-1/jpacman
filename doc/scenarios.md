JPacman Scenarios
=================

Arie van Deursen, Delft University of Technology.


## 1. Background

This document describes a series of JPacman user scenarios, following the format of [behavior-driven development](http://dannorth.net/whats-in-a-story/).

Thus, each scenario is of the form:

---
 **Title** _one line describing the story_

**Narrative**

    As a [role]
     I want [feature]
    So that [benefit]

**Acceptance Criteria,** _presented as scenarios of the form:_

    Scenario 1: Title
    Given [context]
     and  [some more context]...
    When  [event] 
    Then  [outcome]
     and  [another outcome]...
----


## 2. JPacman Overview

JPacman is a very simple JPacman derivative, to be used for educational purposes. Essential features such as multiple levels and multiple players, energizers and different ghost types are postponed for later releases (and may be implemented by students as an exercise).  Furthermore, to give the game a somewhat different flavor, JPacman deviates from standard Pacman behavior in several ways.  This document describes the requirements as a series of use cases, and explains what the GUI should look like.

The JPacman game is played on a rectangular board.  A square on the board can be empty, or can contain the Pacman itself, one of the several ghosts, a pellet (worth 10 points), or a wall. Moveable characters such as the Pacman and the ghosts can make single-step horizontal or vertical moves.  Tunnels on the border make it possible to move from one border to the opposite border.  When the Pacman moves over a square containing a pellet, the player earns points and the pellet disappears. If a player and a ghost meet at the same square, the the game is over. The player wins the game once he or she has eaten all pellets.
JPacman是一个非常简单的JPacman衍生物，用于教育目的。诸如多个关卡、多个玩家、能量补充器和不同幽灵类型等基本功能将被推迟到以后的发行中(游戏邦注:可能由学生作为练习来执行)。此外，为了赋予游戏一些不同的风格，JPacman在一些方面与标准的吃豆人行为有所不同。本文档将需求描述为一系列用例，并解释GUI应该是什么样子的。
日本吃豆人游戏是在一个长方形的棋盘上玩的。棋盘上的方块可以是空的，也可以包含吃豆人本身、几个幽灵中的一个、一个球(价值10点)或一堵墙。可移动的角色，如吃豆人和幽灵可以进行单步水平或垂直移动。边境上的隧道使人们可以从一条边境移动到另一条边境。当吃豆人移动到一个含有小球的方格时，玩家就会获得点数，小球就会消失。如果玩家和鬼魂在同一个方格相遇，游戏就结束了。玩家吃完所有的食物就赢得了游戏。

## 3. User Stories

#### Story 1: Startup

```
As a player
 I want to start the game
so that I can actually play
作为一个玩家
我想开始游戏
这样我就可以玩了
Scenario S1.1: Start.
Given the user has launched the JPacman GUI;
When  the user presses the "Start" button;
Then  the game should start.
假设用户已经启动了JPacman GUI;
当用户按下“开始”按钮时;
然后游戏就应该开始了。
```


#### Story 2: Move the Player

```
As a player, 
 I want to move my Pacman around on the board;
So that I can earn all points and win the game.
作为一个玩家,
我想在棋盘上移动吃豆人;
这样我就能赢得所有的分数并赢得游戏。

Scenario S2.1: The player consumes（玩家消耗）
Given the game has started,
and  my Pacman is next to a square containing a pellet;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square,
 and  I earn the points for the pellet,
 and  the pellet disappears from that square.
既然比赛已经开始了
我的吃豆人就在一个含有小球的方块旁边;
当我向那个方块按下方向键时;
然后我的吃豆人就可以移动到那个方块，
我可以通过吃小球来获得分数
小球就会从那个方块上消失。

Scenario S2.2: The player moves on empty square玩家在空的方块上移动
Given the game has started,
 and  my Pacman is next to an empty square;
When  I press an arrow key towards that square;
Then  my Pacman can move to that square
 and  my points remain the same.
既然比赛已经开始了
我的吃豆人就在一个空的方块旁边;
当我向那个方块按下方向键时;
然后我的吃豆人就可以移动到那个方块
我的观点没有改变。

Scenario S2.3: The move fails移动失败
Given the game has started,
  and my Pacman is next to a cell containing a wall;
When  I press an arrow key towards that cell;
Then  the move is not conducted.
既然比赛已经开始了
我的吃豆人就在一个有墙的细胞旁边;
当我按下那个单元格的方向键;
那么就不进行搬迁了。

Scenario S2.4: The player dies玩家死亡
Given the game has started,
 and  my Pacman is next to a cell containing a ghost;
When  I press an arrow key towards that square;
Then  my Pacman dies,
 and  the game is over.
既然比赛已经开始了
我的吃豆人紧挨着一个包含幽灵的细胞;
当我向那个方块按下方向键时;
然后我的吃豆人死了，
游戏结束了。
  
Scenario S2.5: Player wins, extends S2.1玩家获胜，继承S2.1
When  I have eaten the last pellet;
Then  I win the game.
当我吃完最后一粒时;
然后我赢了比赛。
```


#### Story 3: Move The Ghost移动魔鬼
```
As a ghost;
 I get automatically moved around;
So that I can try to kill the player.
作为一个鬼;
我就会自动移动;
这样我就可以杀死玩家。

Scenario S3.1: A ghost moves.
Given the game has started,
 and  a ghost is next to an empty cell;
When  a tick event occurs;
Then  the ghost can move to that cell.
既然比赛已经开始了
空牢房旁边是一个鬼魂;
当蜱事件发生时;
然后鬼魂就可以转移到那个牢房。

Scenario S3.2: The ghost moves over a square with a pellet.幽灵用小球在正方形上移动。
Given the game has started,
 and  a ghost is next to a cell containing a pellet;
When  a tick event occurs;
Then  the ghost can move to the cell with the pellet,
 and  the pellet on that cell is not visible anymore.
既然比赛已经开始了
幽灵就在一个装有小球的牢房旁边;
当蜱事件发生时;
然后幽灵可以带着小球移动到细胞，
细胞上的颗粒已经看不见了。

Scenario S3.3: The ghost leaves a cell with a pellet.幽灵带着一粒子弹离开了牢房。
Given a ghost is on a cell with a pellet (see S3.2);
When  a tick even occurs;
Then  the ghost can move away from the cell with the pellet,
 and  the pellet on that cell is is visible again.
给定一个幽灵在一个带有小球的细胞上(见S3.2);
当蜱虫出现的时候;
然后幽灵就可以带着小球离开细胞，
细胞上的颗粒再次可见。

Scenario S3.4: The player dies.
Given the game has started,
 and  a ghost is next to a cell containing the player;
When  a tick event occurs;
Then  the ghost can move to the player,
 and  the game is over.
既然比赛已经开始了
幽灵就在包含玩家的单元格旁边;
当蜱事件发生时;
然后幽灵可以移动到玩家身上，
游戏结束了。
```

#### Story 4: Suspend the Game

```
As a player,
 I want to be able to suspend the game;
So  that I can pause and do something else.

Scenario S4.1: Suspend the game.
Given the game has started;
When  the player clicks the "Stop" button;
Then  all moves from ghosts and the player are suspended.

Scenario S4.2: Restart the game.
Given the game is suspended;
When  the player hits the "Start" button;
Then  the game is resumed.
```

## 3. User Interface

The user interface for JPacman is relatively simple.  The game is
rectangular board, which can be read from a special text file with
simple character encoding. On the GUI, special (animated) images or
colored squares are used for the ghost, food, empty cells, and wall
cells on the board.  The direction of the last (attempted) move is
reflected in the image used for the player. The GUI furthermore
contains a "Start", and "Stop" button (at the bottom of the
GUI), as well as an indicator for the amount of food eaten and the
game's overall state (playing, game won, player died, ready to start
the play). 

## 4. Development Requirements

JPacman should be developed in Java. It should be set up so that it
can easily be used by (the latest versions of) standard (open source) Java development tools, such as maven, JUnit, Eclipse/IntelliJ, cobertura, etc. To allow for working with maven, the maven standard directory structure should be used.  Since the educational purposes include testing, JPacman should be delivered with an extensive test suite.

----
[![Creative Commons License](http://i.creativecommons.org/l/by-sa/4.0/88x31.png)](http://creativecommons.org/licenses/by-sa/4.0/)

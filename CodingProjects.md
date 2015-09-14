# Introduction #

<p>As you can tell, this page contains different coding projects available for your coding pleasure.</p>
<p><b>When you take a project</b>......put an underscore at the beginning and the end of the project to indicate it is taken, put your name in Italics also so we know who is working on it</p>
<p><b>needless to say don't work on something that is in Italics</b></p>

# Projects #

```

*Andrew Siegle*<br>
Example project
this project is to show n00bs how to use this wiki page
```
```

Example project 2
this project would be one that is available
```

```

_
*Josh Fiorio*<br>
PokemonBox()
_

*Adam Hendricksono*<br>
BattleBox() done
_



//this contains x number of pokemon

make your own background or take one from online and stretch it to fit the window
display pokemon images and cursors and numbers appropriately
the box needs a nickname (Box x by default where x is an integer)
the box needs a collection(arraylist, list, collection) of Pokemon


==================
YOU GET THIS ONE TOO

*Shloka*<br>ItemBox() (*DONE But has issue with Item Set*)
same thing but the collction will be of Items, keyItems, pokeballs, or TMs

==================

both classes need methods to return and set the box name

both classes need a way to obtain all of the collection elements and one at a specific index
```

```


ComputerPresenter
//this shows the current box and the contents of each

the game will contain 15 boxes, look at the javadoc and communicate with the Box person
for what you need to make

drawOn(Graphics2D g)
this draws everything based on the current Box

buttonPressed(Button b)
move the cursor...try to figure it out if you cant.....ask me
control teh cursor using indexes that way u know where to draw the cursor

step()
nothing
```

```

townMap(MapLocation, Image)
//this shows the town map sprite with a flashing icon

static enum MapLocation to include a name and a point
i.e. Route1, new Point(200,100)  --or something lk that

drawOn(Graphics2D g)
draw the town map and a flashing icon

step
nothing

buttonPressed
LATER: allow the player to move a cursor and display the area they are over
```

```

PokedexPresenter (unclaimed)

open PokedexSpeciesPresenters, etc as appropriate
```

```

PokedexSpeciesPresenter _FINISHED BY SOMEONE TOO STUPID TO LOOK AT THE WIKI_

constructor should take one argument of type Species and a second argument of type Presenter

this displays species info in the pokedex, the details that show in game if you press A on a pokemon in the pokedex

drawOn(Graphics2D g)
this needs to draw a background sprite from one of the sites (or design your own)
then all of this pokemon's info needs to be displayed appropriately

step()
nothing

buttonPressed(Button b)
B button backs out, i.e. enterPresenter(oldPresenter)

```

```

*Jon Borgetti*
Item Class DONE
```




```

*Joe*
a small separate program that will check for and delete unused gif files in ./tileImages/
(that is, images with no references in any of the area files)

you can iterate over all the files in the directory using
File dir = new File("./tileImages");
for(File each: dir.listFiles())
{
//do something with each
}
```

```

*Frick*
a small separate program that will check for duplicates gif files in ./tileImages/
(it is a duplicate if both file has the same sequence of bytes)
this program will delete one or the other, and replace references in the area files
with the image that is retained.

you will probably want to do this by filling a Map<File,File> with assoications of file replaced to file replacement
```
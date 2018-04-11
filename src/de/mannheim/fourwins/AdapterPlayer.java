package de.mannheim.fourwins;

class AdapterPlayer
implements Player
{
private GameGUI theGUI;
private MoveDescr theMove;

/**
 * Put the Gui
 * @param g
 */
void putTheGUI( GameGUI g ) { theGUI = g; }

public synchronized MoveDescr draw() {
  theGUI.enableMove();
  try{
    wait();
  } catch( InterruptedException ie ) {
    return MoveDescr.dummy;
  }
  return theMove;  
}

synchronized void notifyMove( MoveDescr mvd ) {
  theMove = mvd;
  notify();
}
}

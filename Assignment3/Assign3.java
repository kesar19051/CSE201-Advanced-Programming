import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Assign3 {

    public int getRandomElement(ArrayList<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to Mafia!");
        Random random = new Random(); //for assigning all the players their characters
        Scanner in = new Scanner(System.in);
        int numPlayers;

        //taking the input for number of players
        do {
            System.out.println("Enter the number of players: ");
            numPlayers = in.nextInt();
        } while (numPlayers < 6);

        //setting the number of each character
        Game.setNumOfPlAyers(numPlayers);
        Game.setNumOfMafias(numPlayers/5);
        Game.setNumOfDetectives(numPlayers/5);
        Game.setNumOfHealers(Math.max(1, numPlayers/10));
        //setting the number of commoners;
        Game.setNumOfCommoners(Game.getNumOfPlAyers()-Game.getNumOfMafias()-Game.getNumOfDetectives()-Game.getNumOfHealers());
        //Game.numOfCommoners = numPlayers-Game.numOfMafias-Game.numOfDetectives-Game.numOfHealers;

        //asking for a character;
        System.out.println("Choose a character");
        System.out.println("1) Mafia");
        System.out.println("2) Healer");
        System.out.println("3) Detective");
        System.out.println("4) Commoner");
        System.out.println("5) Assign randomly");
        int option = in.nextInt();
        
        Player user = null;

        if(option>=1 && option<=4){
            user = Game.assignCharacter(option);
        }
        else if(option==5){
            option = 1+random.nextInt(4);
            user = Game.assignCharacter(option);
        }
        else{
            System.out.println("INVALID INPUT! Start the game again.");
            return;
        }

        //all players are created and then the game will start
        Game.createPlayers();
        Game.printCharacter(user);
        //Game.display();

        //Reassign the numbers of each type of players so that it can be used later.
        Game.setNumOfPlAyers(numPlayers);
        Game.setNumOfMafias(numPlayers/5);
        Game.setNumOfDetectives(numPlayers/5);
        Game.setNumOfHealers(Math.max(1, numPlayers/10));
        Game.setNumOfCommoners(Game.getNumOfPlAyers()-Game.getNumOfMafias()-Game.getNumOfDetectives()-Game.getNumOfHealers());


        //Game starts
        int round = 1;

        while (true){
            //Game.display();

            boolean isMafia = false;
            System.out.println("Round "+round);
            round+=1;
            System.out.println("The remaining players are ");
            Game.displayPlayers();

            //checks if user is the mafia, completes what mafia does
            ArrayList<Integer> idOfPlayers = Game.getIdOfPlayers();
            GenericList<Player> players = Game.getPlayers();
            if(user instanceof Mafia && idOfPlayers.contains(user.getId())){
                while (true){
                    System.out.println("Choose a target");
                    Game.displayPlayers();
                    int idOfTarget = in.nextInt();
                    if(idOfPlayers.contains(idOfTarget)){
                        Game.setTarget(idOfTarget);
                        ((Mafia) user).kill(Game.getTarget());
                        break;
                    }
                    else {
                        System.out.println("The player you entered is no more in the game.");
                        System.out.println("Choose another player");
                    }
                }
            }
            else{
                while (true) {
                    if(Mafia.mafias.size()!=0) {
                        Assign3 o = new Assign3();
                        int idOfTarget = o.getRandomElement(idOfPlayers);
                        int flag = 0;
                        for (int i = 0; i < players.size(); i++) {
                            Player player = players.get(i);
                            if (player.getId() == idOfTarget && !(player instanceof Mafia)) {
                                Game.setTarget(player.getId());
                                Mafia mafia = Mafia.mafias.get(0);
                                mafia.kill(player);
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            System.out.println("Mafias have chosen their target.");
                            break;
                        }
                    }
                    else
                        System.out.println("Mafias have chosen their target.");
                }
            }

            //System.out.println("The target is "+Game.target.getId());

            //Game.display();

            //detective does its job
            if(user instanceof Detective && idOfPlayers.contains(user.getId())){
                while (true) {
                    System.out.println("Choose a player to test: ");
                    Game.displayPlayers();
                    int idOfPlayer = in.nextInt();
                    if(!idOfPlayers.contains(idOfPlayer)){
                        System.out.println("The player you entered is no more in the game.");
                        System.out.println("Choose another player");
                        continue;
                    }
                    int flag = 0;
                    for (int i = 0; i < Detective.detectives.size(); i++) {
                        Detective detective = Detective.detectives.get(i);
                        if (detective.getId() == idOfPlayer) {
                            System.out.println("You cannot choose a detective!");
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==1)
                        continue;
                    else {
                        isMafia = ((Detective) user).detect(idOfPlayer);
                        if(isMafia) {
                            Game.eliminate(idOfPlayer);
                            System.out.println("Player "+idOfPlayer+" is a mafia and is kicked out.");
                            if(user.getId()==idOfPlayer){
                                System.out.println("You are kicked out.");
                                return;
                            }
                        }
                        else System.out.println("Player "+idOfPlayer+" is not a mafia.");
                        break;
                    }
                }
            }
            else{
                System.out.println("Detectives have chose someone to test.");
                Assign3 o = new Assign3();
                int id = o.getRandomElement(idOfPlayers);
                if(Detective.detectives.size()!=0){
                    Detective detective = Detective.detectives.get(0);
                    isMafia = detective.detect(id);
                }
                if(isMafia) {
                    Game.eliminate(id);
                    System.out.println("Player "+id+" is a mafia and is kicked out.");
                    if(user.getId()==id){
                        System.out.println("You are kicked out.");
                    }
                }
            }

            //Healers will do their job here
            if(user instanceof Healer && idOfPlayers.contains(user.getId())){
                while (true){
                    System.out.println("Choose someone to heal: ");
                    Game.displayPlayers();
                    int idOfPlayer = in.nextInt();
                    if(!idOfPlayers.contains(idOfPlayer)){
                        System.out.println("The player you entered is no more in the game.");
                        System.out.println("Choose another player");
                        continue;
                    }
                    ((Healer) user).heal(idOfPlayer);
                    System.out.println("Player "+idOfPlayer+" is healed.");
                    break;
                }
            }
            else{
                Assign3 o = new Assign3();
                int idOfPlayer = o.getRandomElement(idOfPlayers);
                if(Healer.healers.size()!=0){
                    Healer h = Healer.healers.get(0);
                    h.heal(idOfPlayer);
                }
                System.out.println("Healers have chosen someone to heal.");
            }

            //Game.display();

            if(Game.getTarget().getHP()==0){
                Game.eliminate(Game.getTarget().getId());
                System.out.println("Player "+Game.getTarget().getId()+" died.");
            }
            else{
                System.out.println("No one died.");
            }

            //Game.display();

            if(Game.getTarget().equals(user) && user.getHP()==0){
                System.out.println("You died.");
            }
            int idEliminated = 0;
            if(!isMafia && idOfPlayers.contains(user.getId())) {
                while (true){
                    System.out.println("Enter the player number to vote out: ");
                    int playerId = in.nextInt();
                    if(idOfPlayers.contains(playerId)){
                        System.out.println("You voted against Player "+playerId);
                        break;
                    }
                    else{
                        System.out.println("The player you entered is no more in the game.");
                        System.out.println("Choose another player");
                    }
                }
                idEliminated = Game.voteOut();
            }
            else if(!isMafia){
                idEliminated = Game.voteOut();
            }
            if(user.getId()==idEliminated){
                System.out.println("You are voted out.");
            }

            //Game.display();

            if(Game.ifMafiasWon() || Game.getNumOfMafias()==0){
                System.out.println("Game over!");
                if(Game.ifMafiasWon()){
                    System.out.println("Mafias Won");
                }
                else{
                    System.out.println("Mafias Lost");
                }
                Game.showAllPlayers();
                return;
            }
        }
    }
}

class Game{
    private static final GenericList<Player> finalPlayers = new GenericList<>();
    private static int numOfPlAyers;
    private static int numOfMafias;
    private static int numOfHealers;
    private static int numOfDetectives;
    private static int numOfCommoners;
    private static final GenericList<Player> players = new GenericList<>();
    private static final ArrayList<Integer> idOfPlayers = new ArrayList<>();
    private static Player target;

    public static ArrayList<Integer> getIdOfPlayers() {
        return idOfPlayers;
    }

    public static GenericList<Player> getFinalPlayers() {
        return finalPlayers;
    }

    public static GenericList<Player> getPlayers() {
        return players;
    }

    public static int getNumOfPlAyers() {
        return numOfPlAyers;
    }

    public static int getNumOfMafias() {
        return numOfMafias;
    }

    public static int getNumOfHealers() {
        return numOfHealers;
    }

    public static int getNumOfDetectives() {
        return numOfDetectives;
    }

    public static int getNumOfCommoners() {
        return numOfCommoners;
    }

    public static void setNumOfPlAyers(int numOfPlAyers) {
        Game.numOfPlAyers = numOfPlAyers;
    }

    public static void setNumOfMafias(int numOfMafias) {
        Game.numOfMafias = numOfMafias;
    }

    public static void setNumOfHealers(int numOfHealers) {
        Game.numOfHealers = numOfHealers;
    }

    public static void setNumOfDetectives(int numOfDetectives) {
        Game.numOfDetectives = numOfDetectives;
    }

    public static void setNumOfCommoners(int numOfCommoners) {
        Game.numOfCommoners = numOfCommoners;
    }

    public static void setTarget(Player target) {
        Game.target = target;
    }

    public static Player getTarget() {
        return target;
    }

    public static void showAllPlayers(){
        GenericList<Player> m = new GenericList<>();
        GenericList<Player> h = new GenericList<>();
        GenericList<Player> d = new GenericList<>();
        GenericList<Player> c = new GenericList<>();
        for(int i = 0; i<finalPlayers.size(); i++){
            Player player = finalPlayers.get(i);
            if(player instanceof Mafia)
                m.add(player);
            else if(player instanceof Healer)
                h.add(player);
            else if(player instanceof Detective)
                d.add(player);
            else if(player instanceof Commoner)
                c.add(player);
        }
        for (int i = 0; i<m.size(); i++){
            System.out.print(m.get(i).toString()+", ");
            if(i==m.size()-1){
                System.out.print("were mafias.");
            }
        }
        System.out.println();
        for (int i = 0; i<h.size(); i++){
            System.out.print(h.get(i).toString()+", ");
            if(i==h.size()-1){
                System.out.print("were healers.");
            }
        }
        System.out.println();
        for (int i = 0; i<d.size(); i++){
            System.out.print(d.get(i).toString()+", ");
            if(i==d.size()-1){
                System.out.print("were detectives.");
            }
        }
        System.out.println();
        for (int i = 0; i<c.size(); i++){
            System.out.print(c.get(i).toString()+", ");
            if(i==c.size()-1){
                System.out.print("were commoners.");
            }
        }
    }

    public static boolean ifMafiasWon(){
        int numOfOtherPlayers = numOfDetectives+numOfCommoners+numOfHealers;
        if(numOfMafias==numOfOtherPlayers)
            return true;
        return false;
    }

    public static int voteOut(){
        Random random = new Random();
        int index = random.nextInt(idOfPlayers.size());
        int id = idOfPlayers.get(index);
        eliminate(id);
        System.out.println("Player "+id+" is kicked out.");
        return id;
    }

    public static void setTarget(int id) {
        for (int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            if(player.getId()==id) {
                Game.target = player;
                return;
            }
        }
    }

/*
    public static void display(){
        for(int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            String cls = ""+player.getClass();
            System.out.println("Player " +player.getId()+" "+cls+" HP = "+player.getHP());
        }
    }
*/

    public static void displayPlayers(){
        for(int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            if(i==players.size()-1){
                System.out.print(player.toString()+ " ");
            }
            else
                System.out.print(player.toString()+", ");
        }
        System.out.println();
    }

    public static void eliminate(int id){
        for(int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            if(player.getId()==id){
                players.remove(i);
                numOfPlAyers-=1;
                if(player instanceof Mafia){
                    for(int j = 0; j<Mafia.mafias.size(); j++){
                        Mafia mafia = Mafia.mafias.get(j);
                        if(mafia.getId()==id){
                            Mafia.mafias.remove(j);
                            numOfMafias-=1;
                        }
                    }
                }
                else if(player instanceof Healer){
                    for(int j = 0; j<Healer.healers.size(); j++){
                        Healer healer = Healer.healers.get(j);
                        if(healer.getId()==id){
                            Healer.healers.remove(j);
                            numOfHealers-=1;
                        }
                    }
                }
                else if(player instanceof Detective){
                    for(int j = 0; j<Detective.detectives.size(); j++){
                        Detective detective = Detective.detectives.get(j);
                        if(detective.getId()==id){
                            Detective.detectives.remove(j);
                            numOfDetectives-=1;
                        }
                    }
                }
                else if(player instanceof Commoner)
                    numOfCommoners-=1;
                break;
            }
        }
        for(int i = 0; i<idOfPlayers.size(); i++){
            if(id==idOfPlayers.get(i)){
                idOfPlayers.remove(i);
                return;
            }
        }
    }

    public static Player assignCharacter(int option){
        if(option==1){
            Mafia m = new Mafia();
            Mafia.mafias.add(m);
            players.add(m);
            finalPlayers.add(m);
            idOfPlayers.add(m.getId());
            numOfMafias-=1;
            return m;
        }
        else if(option==2){
            Healer h = new Healer();
            Healer.healers.add(h);
            players.add(h);
            finalPlayers.add(h);
            idOfPlayers.add(h.getId());
            numOfHealers-=1;
            return h;
        }
        else if(option==3){
            Detective d = new Detective();
            Detective.detectives.add(d);
            players.add(d);
            finalPlayers.add(d);
            idOfPlayers.add(d.getId());
            numOfDetectives-=1;
            return d;
        }
        else if(option==4){
            Commoner c = new Commoner();
            players.add(c);
            finalPlayers.add(c);
            idOfPlayers.add(c.getId());
            numOfCommoners-=1;
            return c;
        }
        return null;
    }

    public static void createPlayers(){
        //creating all mafias
        for(int i = 0; i<Game.numOfMafias; i++){
            Mafia player = new Mafia();
            players.add(player);
            finalPlayers.add(player);
            idOfPlayers.add(player.getId());
            Mafia.mafias.add(player);
        }

        //creating all healers
        for(int i = 0; i<Game.numOfHealers; i++){
            Healer player = new Healer();
            players.add(player);
            finalPlayers.add(player);
            idOfPlayers.add(player.getId());
            Healer.healers.add(player);
        }

        //creating all detectives
        for(int i = 0; i<Game.numOfDetectives; i++){
            Detective player = new Detective();
            players.add(player);
            finalPlayers.add(player);
            idOfPlayers.add(player.getId());
            Detective.detectives.add(player);
        }

        //creating all commoners
        for(int i = 0; i<Game.numOfCommoners; i++){
            Commoner player = new Commoner();
            players.add(player);
            finalPlayers.add(player);
            idOfPlayers.add(player.getId());
        }
    }

    public static void printCharacter(Player user){
        if(user instanceof Mafia){
            System.out.println("You are player "+user.getId());
            System.out.println("You are a mafia.");
            user.display();
        }
        else if(user instanceof Healer){
            System.out.println("You are player "+user.getId());
            System.out.println("You are a healer.");
            user.display();
        }
        else if(user instanceof Detective){
            System.out.println("You are player "+user.getId());
            System.out.println("You are a detective.");
            user.display();
        }
        else if(user instanceof Commoner){
            System.out.println("You are player "+user.getId());
            System.out.println("You are a Commoner.");
            user.display();
        }
    }
}

abstract class Player implements Comparator<Player> {
    private final int id;
    private int HP;
    private static int nextId;

    {
        nextId +=1;
    }

    Player(){
        this.id = nextId;
    }

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getHP()-o2.getHP();
    }

    @Override
    public String toString() {
        return "Player " +id;
    }

    abstract void display();

    public int getId() {
        return id;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }
}

class Mafia extends Player{
    public static ArrayList<Mafia> mafias = new ArrayList<>();

    Mafia(){
        super();
        this.setHP(2500);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!= null && obj.getClass()==getClass()){
            Mafia o = (Mafia) obj;
            return this.getId()==o.getId();
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("All mafias are: ");
        for(int i = 0; i<mafias.size(); i++){
            System.out.println(mafias.get(i).toString());
        }
    }

    public void kill(Player player){
        Player comparator = new Commoner();
        for(int i = 0; i<mafias.size(); i++){
            Mafia mafia = mafias.get(i);
            if(mafia.getId()==player.getId()) {
                return;
            }
        }
        for(int i = 0; i<mafias.size(); i++){
            Mafia mafia = mafias.get(i);
            if(comparator.compare(mafia, player)>=0 && player.getHP()!=0){
                mafia.setHP(mafia.getHP()-player.getHP());
                player.setHP(0);
                return;
            }
            else{
                player.setHP(player.getHP()-mafia.getHP());
                mafia.setHP(0);
            }
        }
    }
}

class Healer extends Player{
    public static ArrayList<Healer> healers = new ArrayList<>();

    Healer(){
        super();
        this.setHP(800);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!= null && obj.getClass()==getClass()){
            Healer o = (Healer) obj;
            return this.getId()==o.getId();
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("All healers are: ");
        for(int i = 0; i<healers.size(); i++){
            System.out.println(healers.get(i).toString());
        }
    }

    public void heal(int id){
        GenericList<Player> players = Game.getPlayers();
        for(int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            if(player.getId()==id){
                player.setHP(player.getHP()+500);
                break;
            }
        }
    }
}

class Detective extends Player{
    public static ArrayList<Detective> detectives = new ArrayList<>();

    Detective(){
        super();
        this.setHP(800);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!= null && obj.getClass()==getClass()){
            Detective o = (Detective) obj;
            return this.getId()==o.getId();
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("All detectives are: ");
        for(int i = 0; i<detectives.size(); i++){
            System.out.println(detectives.get(i).toString());
        }
    }

    public boolean detect(int id){
        GenericList<Player> players = Game.getPlayers();
        for(int i = 0; i<players.size(); i++){
            Player player = players.get(i);
            if(player.getId()==id){
                if(player instanceof Mafia){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}

class Commoner extends Player{

    Commoner(){
        super();
        this.setHP(1000);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!= null && obj.getClass()==getClass()){
            Commoner o = (Commoner) obj;
            return this.getId()==o.getId();
        }
        return false;
    }

    @Override
    void display() {
        return;
    }
}

class GenericList <T>{
    private ArrayList<T> myList;
    public GenericList(){
        myList = new ArrayList<>();
    }
    public void add(T o){
        myList.add(o);
    }
    public T get(int i){
        return myList.get(i);
    }

    public int size(){
        return myList.size();
    }

    public void remove(int i){
        myList.remove(i);
    }
}
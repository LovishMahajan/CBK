
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
class Music 
{
	public static void main(String[] args) 
	{
	}
	public static void loginMusic()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/Login.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	public static void BackVoice()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/BackMusic.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	public static void StartQuestion()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/StartQuestion.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
	}



public static void wrong()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/wrong.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}


public static void correct()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/correct.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
	}

public static void lifeline()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/lifeline.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
public static void TikTik()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/TikTik.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
public static void TimeOver()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/TimeOver.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	public static void AudienceVoting()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/AudienceVoting.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
public static void EnterVoice()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/EnterVoice.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
public static void FreeArea()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/FreeArea.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	}
	public static void AudienceRightAnswer()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/AudienceRightAnswer.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
	public static void LockMusic()
	{
	     try 
        {
            FileInputStream file=new FileInputStream("music/LockMusic.mp3");
            Player p=new Player(file);
            p.play();
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }

	
	}
	






}

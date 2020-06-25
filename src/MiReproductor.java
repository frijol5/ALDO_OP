import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.util.ArrayList;
import java.util.Scanner;
class MiReproductor
{
    private Synthesizer synthe = null;
    private int intensity = 100;
    private MidiChannel [] channels;
    private MidiChannel channel;
    private Instrument[] instrumentos;


    public MiReproductor()
    {
        try
        {

            synthe = MidiSystem.getSynthesizer();
        }
        catch(Exception e)
        {
            System.out.println("Error al obtener el Syntetizador ");
        }
    }
    public void inicializar()
    {
        try
        {
            synthe.open();
            channels = synthe.getChannels();
            instrumentos = synthe.getLoadedInstruments();
            for (Instrument i : instrumentos ) {
                System.out.println(i);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al inicializar el Syntetizador");
        }
    }
    public void reproducirNota(int nota, int canal, int duracion)
    {
        channel = channels[canal];
        channel.noteOn(nota,intensity);
        try
        {
            Thread.sleep(duracion);
        }
        catch(Exception e)
        {
            System.out.println("Error en sleep");
        }
        channel.noteOff(nota);
    }
    public void finalizar()
    {
        try
        {
            synthe.close();
        }
        catch(Exception e)
        {
            System.out.println("No jalo terminar");
        }
    }
    public void reproducirAcorde(int nota1, int nota2, int nota3, int nota4, int canal, int duracion)
    {
        channel = channels[canal];
        channel.programChange(25);
        channel.noteOn(nota1,intensity);
        channel.noteOn(nota2,intensity);
        channel.noteOn(nota3,intensity);
        channel.noteOn(nota4,intensity);

        try
        {
            Thread.sleep(duracion);
        }
        catch(Exception e)
        {
            System.out.println("Error en sleep");
        }
        channel.noteOff(nota1);
        channel.noteOff(nota2);
        channel.noteOff(nota3);
        channel.noteOff(nota4);
    }
    public void reproducirAcordenotas(ArrayList<Integer> notas, int n, int canal, int duracion)
    {
        channel = channels[canal];
        for (int i=0;i<n ;i++)
        {
            channel.noteOn(notas.get(i),intensity);
        }
        try
        {
            Thread.sleep(duracion);
        }
        catch(Exception e)
        {
            System.out.println("Error en sleep");
        }
        for (int y = 0;y<n;y++ )
        {
            channel.noteOff(notas.get(y));
        }
    }
    public void ingresarNotas()
    {
        MiReproductor mr = new MiReproductor();
        Scanner a = new Scanner(System.in);

        try
        {
            System.out.println("Escoja cuantas notas va a Ingresar");
            int notas= a.nextInt();
            int[] u = new int[notas];
            int[] uu= new int[notas];
            for (int i=0;i<notas;i++)
            {
                System.out.println("Ingrese el numero de la nota que quiera reproducir");
                u[i]= a.nextInt();
                System.out.println("Ingrese la velocidad");
                uu[i] =a.nextInt();
            }
            mr.inicializar();
            for (int x=0;x<notas;x++ )
            {
                mr.reproducirNota(u[x],1,uu[x]);
            }
            mr.finalizar();
        }
        catch(Exception e)
        {
            System.out.println("No jalo pa");
        }
    }
    public void cambiarInstrumento(int bank, int preset)
    {
        try {
            channel.programChange(bank,preset);
        }catch (Exception e)
        {
            System.out.println("peto");
        }
    }
}
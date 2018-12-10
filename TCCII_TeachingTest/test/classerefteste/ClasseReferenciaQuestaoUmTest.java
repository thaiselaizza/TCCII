import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*; 

public class ClasseReferenciaQuestaoUmTest { 

    private PrintStream orig;
    private PrintStream outStream;
    private BufferedReader buf;
    public ClasseReferenciaQuestaoUmTest() {
    } 

    @BeforeClass
    public static void setUpClass() {
    } 

    @AfterClass
    public static void tearDownClass() {
    } 

    @Before
    public void setUp() { 

        this.orig = System.out;
        PipedOutputStream pipeOut = new PipedOutputStream();
        this.outStream = new PrintStream(pipeOut);
        System.setOut(this.outStream);
        try {
            buf = new BufferedReader(new InputStreamReader(new PipedInputStream(pipeOut)));
        } catch (Exception e) {
            throw new RuntimeException("An error occured while rerouting System.out");
        }
    } 

    @After 
    public void tearDown() { 

        this.outStream.flush();
        this.outStream.close();
        System.setOut(this.orig);
    } 

    @Test
    public void casoTeste1(){ 

        try{
            String[] args = {"15"};
            ClasseReferenciaQuestaoUm.main(args);
            String resultadoEsperado = "Valor aceito";
            String resultadoAtual = this.buf.readLine();
            assertEquals(resultadoEsperado,resultadoAtual);
        } catch (Exception e){
            fail("Exception occurred: " + e.getMessage());
        }
    } 

    @Test
    public void casoTeste2(){ 

        try{
            String[] args = {"8"};
            ClasseReferenciaQuestaoUm.main(args);
            String resultadoEsperado = "Valor rejeitado";
            String resultadoAtual = this.buf.readLine();
            assertEquals(resultadoEsperado,resultadoAtual);
        } catch (Exception e){
            fail("Exception occurred: " + e.getMessage());
        }
    } 

    @Test
    public void casoTeste3(){ 

        try{
            String[] args = {"89"};
            ClasseReferenciaQuestaoUm.main(args);
            String resultadoEsperado = "Valor rejeitado";
            String resultadoAtual = this.buf.readLine();
            assertEquals(resultadoEsperado,resultadoAtual);
        } catch (Exception e){
            fail("Exception occurred: " + e.getMessage());
        }
    } 

} 


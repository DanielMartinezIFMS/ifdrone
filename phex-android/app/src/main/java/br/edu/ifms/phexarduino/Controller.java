package br.edu.ifms.phexarduino;


import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Build;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import br.edu.ifms.phexarduino.comunicacao.USBSerial;
import br.edu.ifms.phexarduino.sensor.Acelerometro;
import br.edu.ifms.phexarduino.sensor.Anemometro;
import br.edu.ifms.phexarduino.sensor.Barometro;
import br.edu.ifms.phexarduino.sensor.CameraVideo;
import br.edu.ifms.phexarduino.sensor.Giroscopio;
import br.edu.ifms.phexarduino.sensor.Gps;
import br.edu.ifms.phexarduino.sensor.Magnetometro;
import br.edu.ifms.phexarduino.sensor.TemperaturaPressao;
import br.edu.ifms.phexarduino.sensor.Ultrasonico;


public class Controller {

    private static final int ALG_PID_PROPORTIONAL_INTEGRAL_DERIVATIVE = 0;
    private static final int ALG_LQR_LINEAR_QUADRATIC_REGULATOR = 1;
    private static final int ALG_LQG_LINEAR_QUADRATIC_GALSSIAN = 2;
    private static final int ALG_BS_BACK_STEPPING = 3;
    private static final int ALG_UFTC_UNIFORM_FAULT_TOLERANCE_CONTROL = 4;

    private static final int VELOCIDADE_PARADA = 0;
    private static final int VELOCIDADE_LENTA = 1;
    private static final int VELOCIDADE_NORMAL = 2;
    private static final int VELOCIDADE_RAPIDA = 3;
    private static final int VELOCIDADE_MUITO_RAPIDA = 4;
    private static final int VELOCIDADE_CALCULADA = 5;



    private Boolean dev = true;
    private static final int LIMITE_CONEXAO = 50;
    private final int ROTOR_IGNICAO = 65;
    private final int FREQUENCIA = 100;
    private int algoritmo = ALG_PID_PROPORTIONAL_INTEGRAL_DERIVATIVE;
    private boolean altitudePorGPS = false;
    private Boolean conexaoLora = false;

    public double latitude_base;
    public double longitude_base;
    public Double altitude_base;


    private MainActivity act;
    private JobScheduler jobScheduler;


    private final Barometro bar;
    private final Anemometro anem;
    private final TemperaturaPressao tepr;
    private final Ultrasonico ultr;
    private final Gps gps;
    private final Magnetometro mag;
    private final Giroscopio giro;
    private final Acelerometro acel;
    private final CameraVideo cam;
    private final USBSerial serial;

    // Controladores
    private final Celular disp;
    private final Controller hexa;

    // plano de voo carregado
    private String plano=null;
    private Queue<Map<String,Object>> fila = new ArrayDeque<>();


    /**** valores sensoriados ******************************/
    /*gps*/
    public Double latitude, longitude;
    /*barometro*/
    public Double altitude, altura, pressao;
    /*termometro*/
    public Double temperatura, humidade;
    /*anemometro*/
    public Double vento_angulo, vento_velocidade;
    /*magnetometro*/
    public Double mag_x,mag_y,mag_z;
    /*giroscopio */
    public Double gir_x,gir_y,gir_z;
    /*acelerometro*/
    public Double ace_x,ace_y,ace_z;
    /*rotores velocidade 1 a 6*/
    public Integer r1=0,r2=0,r3=0,r4=0,r5=0,r6=0;
    /*velocidade de sustentação corrente */
    public Integer s1=0,s2=0,s3=0,s4=0,s5=0,s6=0;

    /*** valores solicitados (o = objetivo/alvo) ******************************/

    public double o_latitude,o_longitude,o_altitude,o_pressao;
    public float o_mag_x,o_mag_y,o_mag_z,o_gir_x,o_gir_y,o_gir_z,o_ace_x,o_ace_y,o_ace_z;
    public int o_r1=0,o_r2=0,o_r3=0,o_r4=0,o_r5=0,o_r6=0;

    /*** 10 valores  anteriores *******************************/

    public double[] a_latitude = new double[]{0d,0d,0d,0d,0d,0d,0d,0d,0d,0d};
    public double[] a_longitude = new double[]{0d,0d,0d,0d,0d,0d,0d,0d,0d,0d};
    public double[] a_altitude = new double[]{0d,0d,0d,0d,0d,0d,0d,0d,0d,0d};
    public double[] a_pressao = new double[]{0d,0d,0d,0d,0d,0d,0d,0d,0d,0d};
    public float[] a_mag_x  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_mag_y  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_mag_z  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_gir_x  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_gir_y  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_gir_z  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_ace_x  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_ace_y  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public float[] a_ace_z  = new float[]{0f,0f,0f,0f,0f,0f,0f,0f,0f,0f};
    public int[] a_r1  = new int[]{0,0,0,0,0,0,0,0,0,0};
    public int[] a_r2  = new int[]{0,0,0,0,0,0,0,0,0,0};
    public int[] a_r3  = new int[]{0,0,0,0,0,0,0,0,0,0};
    public int[] a_r4  = new int[]{0,0,0,0,0,0,0,0,0,0};
    public int[] a_r5  = new int[]{0,0,0,0,0,0,0,0,0,0};
    public int[] a_r6  = new int[]{0,0,0,0,0,0,0,0,0,0};

    /**********************************/




    public Controller(MainActivity act, JobScheduler jobScheduler) {
        this.act = act;
        this.jobScheduler = jobScheduler;
        this.tepr = new TemperaturaPressao(this);
        this.bar = new Barometro(this);
        this.mag = new Magnetometro(this);
        this.gps = new Gps(this, act);
        this.giro = new Giroscopio(this);
        this.acel = new Acelerometro(this);
        this.anem = new Anemometro(this);
        this.ultr = new Ultrasonico(this);
        this.cam = new CameraVideo(this);
        this.serial = new USBSerial(this);
        this.disp = new Celular(this);
        this.hexa = this;
        hexa.iniciar();

    }

    private void iniciar() {
        disp.configurar();
        int q =0;
        // comunicação com arduino
        while(!serial.conectado || !serial.bidirecional) {
            if(!serial.conectado)
                serial.conectar();
            q++;
            if (serial.conectado) {
                serial.testarComunicacao();
            }
            if(q<LIMITE_CONEXAO) {
                disp.alertaAmarelo();
            }else{
                disp.alertaVermelho();
                System.exit(0);
            }
        }
        // estabelecer telemetria com base
        conexaoLora = serial.conectarLora();

        if(conexaoLora){
            disp.alertaVerde();
            // return;
        }else {
            disp.alertaAzul();
        }

        // iniciando processamento em thead isolada

        int result = jobScheduler.schedule(getJobInfo(1, new ComponentName(act, ControllerJob.class)));

        if(result!=JobScheduler.RESULT_SUCCESS){
            disp.erro("Job Não foi iniciado!");
        }


    }

    private JobInfo getJobInfo(final int id, final ComponentName name) {
        final boolean isPersistent = true; // persist through boot
        final int networkType = JobInfo.NETWORK_TYPE_ANY; // Requires some sort of connectivity

        final JobInfo jobInfo;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            jobInfo = new JobInfo.Builder(id, name)
                    .setMinimumLatency(FREQUENCIA)
                    .setRequiredNetworkType(networkType)
                    .setPersisted(isPersistent)
                    .build();
        } else {
            jobInfo = new JobInfo.Builder(id, name)
                    .setPeriodic(FREQUENCIA)
                    .setRequiredNetworkType(networkType)
                    .setPersisted(isPersistent)
                    .build();
        }

        return jobInfo;
    }

    public void sinalize(String mensagem) {
        serial.enviar("sinal",mensagem);
    }
    public void atualizar(CtrlFunction f) {
       f.call(hexa);
    }

    /*
        LI ligar rotores em velocidade mínima
        PA pairar (não subir,descer,girar,avançar ou retroceder)
        SU Subir
        GI Girar para angulo especificado em relação ao norte
        DE Descer
        PO Pousar (reduzir rotores suavemente até que a altitude pare de reduzir)
        DL Desligar rotores
        CF configuração
    */
    private void carregarPlanoVoo(){
        this.plano = "AP500;PP200;LI;PA5;SU1500;GI0;PA5;DE1000;PA5;DE100;PO;DE;";
        for(String d: this.plano.split(";")){
            HashMap<String,Object> op = new HashMap<>();
            op.put("action",d.substring(0,2));
            if(d.length()>2){
                String v = d.substring(2);
                if(v.contains(",")){
                    String[] a = v.split(",");
                    op.put("x", Double.parseDouble(a[0]));
                    op.put("y", Double.parseDouble(a[1]));
                    if(a.length>2) {
                        op.put("z", Double.parseDouble(a[2]));
                    }
                } else {
                    op.put("x", Double.parseDouble(d.substring(2)));
                }
            }
            op.put("done", false);
            this.fila.add(op);
        }
    }

    private void ligar(){
        latitude_base = gps.latitudeCorrente();
        longitude_base = gps.longitudeCorrente();
        altitude_base = bar.altitudeCorrente();
        gir_x = giro.xCorrent();
        gir_y = giro.yCorrent();
        gir_z = giro.zCorrent();
        temperatura = tepr.temperaturaCorrente();
        humidade = tepr.humidadeCorrente();
        vento_angulo = anem.anguloCorrente();
        vento_velocidade = anem.velocidadeCorrente();
        r1 = ROTOR_IGNICAO;
        r2 = ROTOR_IGNICAO;
        r3 = ROTOR_IGNICAO;
        r4 = ROTOR_IGNICAO;
        r5 = ROTOR_IGNICAO;
        r6 = ROTOR_IGNICAO;
    }



    private class ControllerJob extends JobService {


        @Override
        public boolean onStartJob(JobParameters jobParameters) {
            if(fila.size()>0){
                Map<String, Object> e = fila.element();
                if(e.get("done").equals(true)){
                    fila.poll();
                    e = fila.element();
                }
                String action = (String) e.get("action");
                switch(action){
                    case "LI": ligar(); break;
                    case "SU": subir((Double)e.get("x")); break;
                    case "DE": descer((Double)e.get("x")); break;
                    case "PA": pairar((Double)e.get("x")); break;
                    case "GI": girar((Double)e.get("x")); break;
                    case "PO": pousar(); break;
                    case "DL": desligar(); break;
                    default: serial.enviar("ERRO","Comando não reconhecido no plano de voo! action:"+ (String)e.get("action"));
                }
                serial.atualizarRotores();

            }
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    /* ACTION: DC100
        mater-se na posicao geografica
        estabilizar giroscopio
        subir até altura definida

        estagio 1 ajustar inclinação usando motores e força vetorial
                  motores elevados devem ter 3% menos força que os demais

        estagio 2 igualar força dos motores e acelerar para subir
        estagio 3 redusir aceleração até pairar na altura esperada
     */
    private void decolar(Double alturaFinal){
        if(this.altura!=alturaFinal){
           subir(altitude_base+alturaFinal);
        }
        serial.atualizarRotores();
    }
    private void subir(Double altura){

        if(giro.inclinado()){
            giro.ajustarInclinacao();
        }

    }


    private void descer(Double altura){}
    private void pairar(Double segundos){}
    private void pousar(){}

    private void avancar(Double latitude, Double longitude){}
    private void curva(Double latitude, Double longitude,Double angulo){}
    private void balao(Double latitude, Double longitude){}
    private void girar(Double angulo){}
    private void pulverizar(Integer pressao){}
    private void desligar(){}
}

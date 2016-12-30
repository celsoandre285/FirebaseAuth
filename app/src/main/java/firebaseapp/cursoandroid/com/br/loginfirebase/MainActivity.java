package firebaseapp.cursoandroid.com.br.loginfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    //Recuperando instancia de autenticação
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();




        //Login de Usuarios
        firebaseAuth.signInWithEmailAndPassword("celsolog2012@gmail.com","102030")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("FirebaseAuth", "Autenticado com Sucesso");
                        }else{
                            Log.i("FirebaseAuth", task.getException().toString());
                        }
                    }
                });

                //deslogando o usuario
                firebaseAuth.signOut();
        
                //Verificar se o usuario esta logado
                if(firebaseAuth.getCurrentUser()!=null){
                    Log.i("usuarioLogado", "Usuario Logado");
                }else {
                    Log.i("usuarioLogado", "Usuario Deslogado");
                }


        /*
        //Cadastro de usuarios
        firebaseAuth.createUserWithEmailAndPassword("celsolog2012@gmail.com", "102030")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("FirebaseAuth", "Cadastrado com Sucesso");
                        }else{
                            Log.i("FirebaseAuth", "Cadastrado nao realizado");
                        }
                    }
                });*/



    }
}

package br.com.segundotrab.apppizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Selection;
import android.util.ArraySet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

import br.com.segundotrab.appPizza.R;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEndereco;
    private EditText etTelefone;
    private Spinner spSabor;
    private Button btnSalvar;
    private String acao;
    private Pizza pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById( R.id.etNome );
        etEndereco = findViewById( R.id.etEndereco );
        etTelefone = findViewById( R.id.etTelefone );
        spSabor = findViewById( R.id.spSabor);
        btnSalvar = findViewById( R.id.btnSalvar );

        acao = getIntent().getStringExtra("acao");
        if( acao.equals("editar")){
            carregarFormulario();
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void carregarFormulario(){
          int idPizza = getIntent().getIntExtra("idPizza", 0);
        if( idPizza != 0) {
            pizza = PizzaDAO.getPizzaById(this, idPizza);

            etNome.setText( pizza.nome );
            etEndereco.setText( pizza.endereco );
           // spSabor.setSelection(spSabor.getSelectedItemPosition());




            String[] arraySabor = getResources().getStringArray(R.array.arraySabor);
            for(int i = 1; i < arraySabor.length ; i++){
                if(  arraySabor[i]  == pizza.sabor){
                    spSabor.setSelection( i );
                }
            }
        }

    }

    private void salvar(){
       if( spSabor.getSelectedItemPosition() == 0 || etNome.getText().toString().isEmpty() ) {

            Toast.makeText(this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();

        }else{

            if (acao.equals("novo")) {
                pizza = new Pizza();
            }

            pizza.nome = etNome.getText().toString();
            pizza.endereco = etEndereco.getText().toString();
            pizza.sabor = spSabor.getSelectedItem().toString();
            pizza.setTelefone( Integer. valueOf( etTelefone.getText().toString()));

              if( acao.equals("editar")){
                PizzaDAO.editar(pizza, this);
               // finish();
            }else {
                PizzaDAO.inserir(pizza, this);
                etNome.setText("");
                etEndereco.setText("");
                etTelefone.setText("");
                spSabor.setSelection(0);
            }
        }
    }



}

package com.example.poketracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import android.text.InputFilter;
import android.text.Spanned;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText natnumEdit;
    TextView numView;
    EditText heightEdit;
    TextView heightView;
    EditText weightEdit;
    TextView weightView;
    EditText nameEdit;
    TextView nameView;
    EditText speciesEdit;
    TextView speciesView;
    EditText hpEdit;
    TextView hpView;
    EditText attackEdit;
    TextView attackView;
    EditText defenseEdit;
    TextView defenseView;
    TextView genderView;


    RadioGroup genderGroup;
    Spinner spin;




    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            weightEdit.removeTextChangedListener(this);
            //remove kg from the charSeq
            //string.replace or substring (0-len)-3
            weightEdit.toString().replace("kg", "");
            weightEdit.setText(charSequence + "kg");
            weightEdit.addTextChangedListener(this);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    TextWatcher heightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            heightEdit.removeTextChangedListener(this);
            heightEdit.toString().replace("m", "");
            heightEdit.setText(charSequence + "m");
            heightEdit.addTextChangedListener(this);
        }

        @Override
        public void afterTextChanged(Editable editable) {
            //heightEdit.removeTextChangedListener(this);

//            if (heightEdit.getText().toString().compareTo(editable.toString()) != 4) {
//                heightEdit.append("m");
//            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        //setContentView(R.layout.constraint);
        //setContentView(R.layout.table);

        natnumEdit = findViewById(R.id.nnET);
        numView = findViewById(R.id.numTV);
        spin = findViewById(R.id.spinner);
        genderGroup = findViewById(R.id.genGroup);
        genderView = findViewById(R.id.genderTV);
        heightEdit = findViewById(R.id.heightET);
        heightView = findViewById(R.id.heightTV);
        weightEdit = findViewById(R.id.weightET);
        weightView = findViewById(R.id.weightTV);
        nameEdit = findViewById(R.id.nameET);
        nameView = findViewById(R.id.pnameTV);
        speciesEdit = findViewById(R.id.speciesET);
        speciesView = findViewById(R.id.speciesTV);
        hpEdit = findViewById(R.id.hpET);
        hpView = findViewById(R.id.hpTV);
        attackEdit = findViewById(R.id.attackET);
        attackView = findViewById(R.id.attackTV);
        defenseEdit = findViewById(R.id.defenseET);
        defenseView = findViewById(R.id.defenseTV);

        natnumEdit.setFilters(new InputFilter[]{new InputFilterMinMax(0, 1010)});
        List<String> valuesList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            valuesList.add(String.valueOf(i));
        }

        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, valuesList);
        spin.setAdapter(typeAdapter);
        spin.setOnItemSelectedListener(spinListener);

        heightEdit.addTextChangedListener(heightWatcher);
        weightEdit.addTextChangedListener(weightWatcher);

    }
    public void checkButton(View v){
        Toast.makeText(this, v.toString(),Toast.LENGTH_LONG).show();
    }
    public void resetB(View v){
        natnumEdit.setText("896");
        nameEdit.setText("Glastrier");
        speciesEdit.setText("Wild Horse Pokemon");
        heightEdit.setText("2.2 m");
        weightEdit.setText("800.0 kg");
        hpEdit.setText("0");
        attackEdit.setText("0");
        defenseEdit.setText("0");
        nameView.setTextColor(getResources().getColor(R.color.black));
        genderView.setTextColor(getResources().getColor(R.color.black));
        speciesView.setTextColor(getResources().getColor(R.color.black));
        heightView.setTextColor(getResources().getColor(R.color.black));
        weightView.setTextColor(getResources().getColor(R.color.black));
        weightView.setTextColor(getResources().getColor(R.color.black));
        hpView.setTextColor(getResources().getColor(R.color.black));
        attackView.setTextColor(getResources().getColor(R.color.black));
        defenseView.setTextColor(getResources().getColor(R.color.black));


    }

    public void submitB(View v){
        boolean isValid = true;

        if(nameEdit.getText().toString().trim().length() < 3 || nameEdit.getText().toString().trim().length() > 12 || nameEdit == null){
            nameView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        if(!genderGroup.isSelected() || genderGroup == null){
            genderView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        int hp = Integer.parseInt(hpEdit.getText().toString().trim());
        if(hp < 1 || hp > 363 || hpEdit == null){
            hpView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        int attack = Integer.parseInt(attackEdit.getText().toString().trim());
        if(attack < 5 || attack > 526 || attackEdit == null){
            attackView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        int defense = Integer.parseInt(defenseEdit.getText().toString().trim());
        if(defense < 5 || defense > 614 || defenseEdit == null){
            defenseView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        String heightString = heightEdit.getText().toString().trim();
        heightString = heightString.toString().replace("m", "");
        float height = Float.parseFloat(heightString);
        if(height < 0.3 || height > 20 || heightEdit == null){
            heightView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }
        String weightString = weightEdit.getText().toString().trim();
        weightString = weightString.toString().replace("kg", "");
        float weight = Float.parseFloat(weightString);
        if(weight < .1 || weight > 820 || weightEdit == null){
            weightView.setTextColor(getResources().getColor(R.color.red));
            isValid = false;
        }

        if(isValid == true){
            String message = "All information was stored in the database!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        if(isValid == false){
            String message = "One or more errors occured. Highlighted fields must be corrected.";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }


    //spinner setup
    AdapterView.OnItemSelectedListener spinListener = new AdapterView.OnItemSelectedListener(){
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            //parent.getSelectedItem();
            String message = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> parent){

        }
    };

    }
//all of this i got from stackoverflow (: it is extending InputFilter to make sure the national number only goes up to 1010
    class InputFilterMinMax implements InputFilter {
        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                String inputString = dest.toString().substring(0, dstart) + source.toString() + dest.toString().substring(dend);
                int input = Integer.parseInt(inputString);
                if (isInRange(min, max, input)) {
                    return null; // Accept the input
                }
            } catch (NumberFormatException e) {
                // Handle invalid input
            }
            return ""; // Reject the input
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
        //end of stackoverflow dump

    }

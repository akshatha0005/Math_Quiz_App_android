package com.app.akshatha.math_quiz_app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;


public class QuitFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you really want to exit the quiz?");
        builder.setTitle("Quit");
        final AlertDialog.Builder builder1 = builder.setPositiveButton("Resume", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Log.d("ExitFragment", "Quiz Resume");
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Log.d("ExitFragment", "Quiz Exit");
                getActivity().finish();
            }
        });

        return builder.create();
    }


}
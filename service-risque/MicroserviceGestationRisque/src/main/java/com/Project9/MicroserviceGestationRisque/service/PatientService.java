package com.Project9.MicroserviceGestationRisque.service;


import com.Project9.MicroserviceGestationRisque.model.KeyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientService {

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private NoteClient noteClient;


    public int agePatient(Integer id){
      return  patientClient.agePatient(id);
    }

    public String genre(Integer id){
        return patientClient.genrePatient(id);
    }

    int countKeywordOccurrences(String id, String[] keywords){
        return noteClient.countKeywordsInNote(id,keywords);
    }

    public String statusNotePatient(Integer idPatient) {

        if (agePatient(idPatient) < 30) {
            if (Objects.equals(genre(idPatient), "F")) {
                if ((countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) == 4)) {
                    return "le patiente est en danger In Danger)";
                } else if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) >= 7) {
                    return "la patient présente une apparition précoce (Early onset)";
                }
            } else if (Objects.equals(genre(idPatient), "M")) {
                if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) == 3) {
                    return "le patient est en danger (In Danger)";
                } else if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) >= 5) {
                    return "le patient présent une apparition précoce (Early onset)";
                }
            }
        }else if (agePatient(idPatient) > 30) {
            if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) == 6 ||
                    countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) == 7) {
                return "La personne est en danger";
            } else if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) >= 8) {
                return " Le patient présente une apparition précoce";
            }
        }
        if (countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) > 2
                && countKeywordOccurrences(String.valueOf(idPatient), KeyWord.keyWord) < 5) {
            return "Le risque est limité (Borderline)";
        } else  return "Le patient présente aucun risque (None)";
    }

}
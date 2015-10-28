package com.specktre.androidmvp.usercoderepos;

import com.specktre.domain.coderepo.CodeRepo;
import com.specktre.domain.usercoderepos.UserCodingLifeAnalyzer;

import java.util.List;

public class UserCodingLifeAnalyzerImpl implements UserCodingLifeAnalyzer {
    @Override
    public boolean isProgrammerInLanguage(String language, List<CodeRepo> userCodeRepos) {
        for(CodeRepo codeRepo : userCodeRepos) {
            if(language.equalsIgnoreCase(codeRepo.language)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isStar(List<CodeRepo> userCodeRepos) {
        for(CodeRepo codeRepo : userCodeRepos) {
            if(codeRepo.stargazers_count > 1000) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String mostRatedRepo(List<CodeRepo> userCodeRepos) {
        int maxNumberOfStars = 0;
        int atIndex = 0;
        for(int i = 0; i < userCodeRepos.size(); i++) {
            if(userCodeRepos.get(i).stargazers_count > maxNumberOfStars) {
                maxNumberOfStars = userCodeRepos.get(i).stargazers_count;
                atIndex = i;
            }
        }
        return userCodeRepos.get(atIndex).name;
    }
}

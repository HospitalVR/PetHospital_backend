package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.CaseType;
import com.rjsj.pethospital.entity.FullCase;
import com.rjsj.pethospital.entity.PartCase;
import com.rjsj.pethospital.repository.CaseRepository;
import com.rjsj.pethospital.repository.CaseTypeRepository;
import com.rjsj.pethospital.service.CaseService;
import com.rjsj.pethospital.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    CaseTypeRepository caseTypeRepository;

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public Map<String, List<String>> findAllByType() {
        List<CaseType> caseTypes = caseTypeRepository.findAll();
        Map map = new HashMap<String, List<String>>();
        for (CaseType caseType : caseTypes) {
            List<Case> cases = caseRepository.findAllByType(caseType.getType());
            List<String> list = new ArrayList<>();
            for (Case hospitalCase : cases)
                list.add(hospitalCase.getName1());
            map.put(caseType.getType(), list);
        }
        return map;
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Case> cases = caseRepository.findAllByName1Contains(name);
        List<String> casesName = new ArrayList<>();
        for (Case hospitalCase : cases)
            casesName.add(hospitalCase.getName1());
        return casesName;
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public Case findByName(String name) {
        return caseRepository.findByName1(name);
    }

    private synchronized Case save(Case hospitalCase) {
        Case caseExist = caseRepository.findByName1(hospitalCase.getName1());
        if (caseExist != null) {
            hospitalCase.setId(caseExist.getId());
        }
        return caseRepository.save(hospitalCase);
    }

    @Override
    public Case save(HttpServletRequest request) {
        Case hospitalCase = new Case();
        hospitalCase.setType(request.getParameter("type"));
        hospitalCase.setName1(request.getParameter("name1"));
        hospitalCase.setTreat1(request.getParameter("treat1"));
        hospitalCase.setCheck1(request.getParameter("check1"));
        hospitalCase.setResult1(request.getParameter("result1"));
        hospitalCase.setPlan1(request.getParameter("plan1"));

        Case existCase = caseRepository.findByName1(hospitalCase.getName1());

        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;

        if (files.getFile("name2") != null) {
            hospitalCase.setName2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name2")));
        } else if (request.getParameter("name2") == null || request.getParameter("name2").equals("")) {
            if (existCase != null)
                hospitalCase.setName2(existCase.getName2());
        } else if (request.getParameter("name2").equals("delete")) {
            if (existCase.getName2() != null && !existCase.getName2().equals(""))
                FileUtil.removeFile(existCase.getName2());
            hospitalCase.setName2("");
        }

        if (files.getFile("name3") != null) {
            hospitalCase.setName3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name3")));
        } else if (request.getParameter("name3") == null || request.getParameter("name3").equals("")) {
            if (existCase != null)
                hospitalCase.setName3(existCase.getName3());
        } else if (request.getParameter("name3").equals("delete")) {
            if (existCase.getName3() != null && !existCase.getName3().equals(""))
                FileUtil.removeFile(existCase.getName3());
            hospitalCase.setName3("");
        }


        if (files.getFile("check2") != null) {
            hospitalCase.setCheck2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("check2")));
        } else if (request.getParameter("check2") == null || request.getParameter("check2").equals("")) {
            if (existCase != null)
                hospitalCase.setCheck2(existCase.getCheck2());
        } else if (request.getParameter("check2").equals("delete")) {
            if (existCase.getCheck2() != null && !existCase.getCheck2().equals(""))
                FileUtil.removeFile(existCase.getCheck2());
            hospitalCase.setCheck2("");
        }

        if (files.getFile("check3") != null) {
            hospitalCase.setCheck3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-2", files.getFile("check3")));
        } else if (request.getParameter("check3") == null || request.getParameter("check3").equals("")) {
            if (existCase != null)
                hospitalCase.setCheck3(existCase.getCheck3());
        } else if (request.getParameter("check3").equals("delete")) {
            if (existCase.getCheck3() != null && !existCase.getCheck3().equals(""))
                FileUtil.removeFile(existCase.getCheck3());
            hospitalCase.setCheck3("");
        }


        if (files.getFile("treat2") != null) {
            hospitalCase.setTreat2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("treat2")));
        } else if (request.getParameter("treat2") == null || request.getParameter("treat2").equals("")) {
            if (existCase != null)
                hospitalCase.setTreat2(existCase.getTreat2());
        } else if (request.getParameter("treat2").equals("delete")) {
            if (existCase.getTreat2() != null && !existCase.getTreat2().equals(""))
                FileUtil.removeFile(existCase.getTreat2());
            hospitalCase.setTreat2("");
        }

        if (files.getFile("treat3") != null) {
            hospitalCase.setTreat3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-3", files.getFile("treat3")));
        } else if (request.getParameter("treat3") == null || request.getParameter("treat3").equals("")) {
            if (existCase != null)
                hospitalCase.setTreat3(existCase.getTreat3());
        } else if (request.getParameter("treat3").equals("delete")) {
            if (existCase.getTreat3() != null && !existCase.getTreat3().equals(""))
                FileUtil.removeFile(existCase.getTreat3());
            hospitalCase.setTreat3("");
        }


        if (files.getFile("result2") != null) {
            hospitalCase.setResult2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result2")));
        } else if (request.getParameter("result2") == null || request.getParameter("result2").equals("")) {
            if (existCase != null)
                hospitalCase.setResult2(existCase.getResult2());
        } else if (request.getParameter("result2").equals("delete")) {
            if (existCase.getResult2() != null && !existCase.getResult2().equals(""))
                FileUtil.removeFile(existCase.getResult2());
            hospitalCase.setResult2("");
        }

        if (files.getFile("result3") != null) {
            hospitalCase.setResult3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-4", files.getFile("result3")));
        } else if (request.getParameter("result3") == null || request.getParameter("result3").equals("")) {
            if (existCase != null)
                hospitalCase.setResult3(existCase.getResult3());
        } else if (request.getParameter("result3").equals("delete")) {
            if (existCase.getResult3() != null && !existCase.getResult3().equals(""))
                FileUtil.removeFile(existCase.getResult3());
            hospitalCase.setResult3("");
        }


        if (files.getFile("plan2") != null) {
            hospitalCase.setPlan2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan2")));
        } else if (request.getParameter("plan2") == null || request.getParameter("plan2").equals("")) {
            if (existCase != null)
                hospitalCase.setPlan2(existCase.getPlan2());
        } else if (request.getParameter("plan2").equals("delete")) {
            if (existCase.getPlan2() != null && !existCase.getPlan2().equals(""))
                FileUtil.removeFile(existCase.getPlan2());
            hospitalCase.setPlan2("");
        }

        if (files.getFile("plan3") != null) {
            hospitalCase.setPlan3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-5", files.getFile("plan3")));
        } else if (request.getParameter("plan3") == null || request.getParameter("plan3").equals("")) {
            if (existCase != null)
                hospitalCase.setPlan3(existCase.getPlan3());
        } else if (request.getParameter("plan3").equals("delete")) {
            if (existCase.getPlan3() != null && !existCase.getPlan3().equals(""))
                FileUtil.removeFile(existCase.getPlan3());
            hospitalCase.setPlan3("");
        }

        return save(hospitalCase);
    }

    @Async
    public void addMark(Case saveCase) {
        saveCase.setName2(process(saveCase.getName2()));
        saveCase.setCheck2(process(saveCase.getCheck2()));
        saveCase.setTreat2(process(saveCase.getTreat2()));
        saveCase.setResult2(process(saveCase.getResult2()));
        saveCase.setPlan2(process(saveCase.getPlan2()));
        save(saveCase);
        saveCase.setName3(process(saveCase.getName3()));
        saveCase.setCheck3(process(saveCase.getCheck3()));
        saveCase.setTreat3(process(saveCase.getTreat3()));
        saveCase.setResult3(process(saveCase.getResult3()));
        saveCase.setPlan3(process(saveCase.getPlan3()));
        save(saveCase);
    }

    private String process(String fileName) {
        if (fileName == null || fileName.equals(""))
            return null;
        else if (fileName.contains("mark"))
            return fileName;
        File file = new File(FileUtil.fileParent, fileName);
        if (file.exists()) {
            try {
                if (FileUtil.isImage(file)) {
                    return FileUtil.addMark(file);
                } else if (FileUtil.isVideo(file)) {
                    return FileUtil.videoAddMark(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        Case hospitalCase = caseRepository.findByName1(name);
        if (hospitalCase.getName2() != null && !hospitalCase.getName2().equals(""))
            FileUtil.removeFile(hospitalCase.getName2());
        if (hospitalCase.getName3() != null && !hospitalCase.getName3().equals(""))
            FileUtil.removeFile(hospitalCase.getName3());
        if (hospitalCase.getTreat2() != null && !hospitalCase.getTreat2().equals(""))
            FileUtil.removeFile(hospitalCase.getTreat2());
        if (hospitalCase.getTreat3() != null && !hospitalCase.getTreat3().equals(""))
            FileUtil.removeFile(hospitalCase.getTreat3());
        if (hospitalCase.getCheck2() != null && !hospitalCase.getCheck2().equals(""))
            FileUtil.removeFile(hospitalCase.getCheck2());
        if (hospitalCase.getCheck3() != null && !hospitalCase.getCheck3().equals(""))
            FileUtil.removeFile(hospitalCase.getCheck3());
        if (hospitalCase.getResult2() != null && !hospitalCase.getResult2().equals(""))
            FileUtil.removeFile(hospitalCase.getResult2());
        if (hospitalCase.getResult3() != null && !hospitalCase.getResult3().equals(""))
            FileUtil.removeFile(hospitalCase.getResult3());
        if (hospitalCase.getPlan2() != null && !hospitalCase.getPlan2().equals(""))
            FileUtil.removeFile(hospitalCase.getPlan2());
        if (hospitalCase.getPlan3() != null && !hospitalCase.getPlan3().equals(""))
            FileUtil.removeFile(hospitalCase.getPlan3());
        caseRepository.deleteByName1(name);
    }
}

package com.cg.backgroundverification.dao;
import java.util.ArrayList;
public interface VerifierDao 
{
   ArrayList<String[]> getAllPendingDocs();
   boolean updatePendingStatus(int uploadId,char status);
}

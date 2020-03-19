package de.techem.wurst.store.api;

import de.techem.wurst.store.impl.StoreEntry;

public interface StoreService {
	int getStock(String category, String item);

	StoreEntry dumpStock();
}

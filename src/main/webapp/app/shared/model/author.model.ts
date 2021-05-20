import dayjs from 'dayjs';

export interface IAuthor {
  id?: string;
  name?: string | null;
  birthDate?: string | null;
}

export const defaultValue: Readonly<IAuthor> = {};

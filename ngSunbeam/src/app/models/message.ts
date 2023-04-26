import { User } from './user';

export class Message {
  id: number;
  description: string;
  createDate: Date;
  enable: boolean;
  isRead: boolean;
  receiver: User | null;
  sedner: User | null;

  constructor(
    id: number = 0,
    description: string = '',
    createDate: Date = new Date(),
    enable: boolean = true,
    isRead: boolean = false,
    receiver: User | null = null,
    sedner: User | null = null
  ) {
    this.id = id;
    this.description = description;
    this.createDate = createDate;
    this.enable = enable;
    this.isRead = enable;
    this.receiver = receiver;
    this.sedner = sedner;
  }

}
